package lk.ijse.userservice.dto.impl;

import lk.ijse.userservice.dto.UserStatus;
import lk.ijse.userservice.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements UserStatus {
    private String id;
    private String username;
    private String email;
    private String password;
    private Role role;
}
