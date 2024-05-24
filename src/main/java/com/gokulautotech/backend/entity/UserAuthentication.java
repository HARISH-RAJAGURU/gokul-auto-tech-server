package com.gokulautotech.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Employee_Id")
    private Long empId;
    @Column(name = "E-mail")
    private String email;
    @Column(name = "Password")
    private  String password;
}
