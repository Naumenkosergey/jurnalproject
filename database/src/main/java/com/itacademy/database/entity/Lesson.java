package com.itacademy.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"mark", "office", "employee"})

@Entity
@Table(name = "lesson", schema = "jurnalproject_storage")
public class Lesson extends BaseEntity<Long> {

    @Column(name = "data")
    private Instant data;

    @Column(name = "topick")
    private String topick;

    @Column(name = "homework")
    private String homework;

    @OneToOne(mappedBy = "lesson")
    private Mark mark;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
