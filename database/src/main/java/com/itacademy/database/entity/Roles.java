package com.itacademy.database.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(of = "role")
@NoArgsConstructor
@Entity
@Table(name = "roles",schema = "jurnalproject_schema")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;

    @Column(name = "role")
    private String role;
}
