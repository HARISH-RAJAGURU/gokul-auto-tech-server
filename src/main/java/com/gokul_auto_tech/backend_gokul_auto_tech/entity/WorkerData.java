package com.gokul_auto_tech.backend_gokul_auto_tech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "worker_data")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class WorkerData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "division")
    private String division;

    @Column(name = "user_role")
    private String role;

}
