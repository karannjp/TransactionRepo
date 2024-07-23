package com.hcl.TrancationServices.controller;

import com.hcl.TrancationServices.services.TrascationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class PostTransacationController {

    @Autowired
    private TrascationServices trascationServices;

    @PostMapping("/transfer")
public ResponseEntity<String> tramsfer(@RequestParam String debitAccountNo, @RequestParam String creditAccountNo, @RequestParam Double amount){
    try {
        trascationServices.initiateTrascation(debitAccountNo,creditAccountNo,amount);
        return ResponseEntity.ok("Transcation Successful");
    }catch (Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

}
}
