package com.itacademy.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"flow", "faculty", "faculties"})

@Entity
@Table(name = "subject", schema = "jurnalproject_schema")
public class Subject extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "semestr")
    private Integer semestr;

    @ManyToOne()
    @JoinColumn(name = "flow_id")
    private Flow flow;

    @ManyToOne()
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "subject_faculty", schema = "jurnalproject_schema",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id")
    )
    private List<Faculty> faculties = new ArrayList<>();

}
