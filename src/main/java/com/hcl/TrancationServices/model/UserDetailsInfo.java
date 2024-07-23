package com.hcl.TrancationServices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="user_details_info")
@Entity
public class UserDetailsInfo {
    @Id
    private String userId;
    private String userName;
    private String password;
    @OneToMany(mappedBy = "userDetails")
    private List<AccountDetailsInfo> accounts;

}
