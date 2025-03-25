package lk.ijse.userservice.entity.impl;

import jakarta.persistence.*;
import lk.ijse.userservice.entity.Role;
import lk.ijse.userservice.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserEntity implements SuperEntity {
    @Id
    private String id;
    private String username;
    @Column(unique=true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
