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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"flow, students, faculties"})

@Entity
@Table(name = "groupa", schema = "jurnalproject_schema")
public class Groupa extends BaseEntity<Long> {

    @Column(name = "number")
    private Integer number;

    @Column(name = "semestr")
    private Integer semestr;

    @ManyToOne
    @JoinColumn(name = "flow_id")
    private Flow flow;

    @OneToMany(mappedBy = "groupa", fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    @Builder.Default
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "faculty_groupa", schema = "jurnalproject_schema",
            joinColumns = @JoinColumn(name = "groupa_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id")
    )
    private List<Faculty> faculties = new ArrayList<>();

}
