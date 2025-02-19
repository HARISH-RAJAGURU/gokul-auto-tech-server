package com.gokulautotech.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Table(name = "fettlingData")

public class FettlingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Employee_Id")
    private Long empId;

    @Column(name = "Input")
    private Long input;

    @Column(name = "Field-1")
    private Long field1;

    @Column(name = "Field-2")
    private Long field2;

    @Column(name = "Field-3")
    private Long field3;

    @Column(name = "Field-4")
    private Long field4;

    @Column(name = "Output")
    private Long output;

}
