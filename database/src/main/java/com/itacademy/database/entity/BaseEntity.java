package com.itacademy.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString

@MappedSuperclass
public abstract class BaseEntity<PK extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PK id;
}
