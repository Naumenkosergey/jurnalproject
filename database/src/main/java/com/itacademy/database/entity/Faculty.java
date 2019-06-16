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
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"subjects, groupas"})

@Entity
@Table(name = "faculty", schema = "jurnalproject_storage")
public class Faculty extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "subject_faculty", schema = "jurnalproject_storage",
            joinColumns = @JoinColumn(name = "faculty_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects = new ArrayList<>();

    @Builder.Default
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "faculty_groupa", schema = "jurnalproject_storage",
            joinColumns = @JoinColumn(name = "faculty_id"),
            inverseJoinColumns = @JoinColumn(name = "groupa_id")
    )
    private List<Groupa> groupas = new ArrayList<>();
}
