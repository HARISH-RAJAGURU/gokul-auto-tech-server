package com.gokul_auto_tech.backend_gokul_auto_tech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user_authentication")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "employee_id")
    private Long empId;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private  String password;

}
