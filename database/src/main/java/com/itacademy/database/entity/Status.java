package com.itacademy.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = "student")

@Entity
@Table(name = "status", schema = "jurnalproject_schema")
public class Status extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "status")
    private Student student;
}


