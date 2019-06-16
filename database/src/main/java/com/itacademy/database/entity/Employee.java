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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"user,lessons, offices"})
@Entity
@Table(name = "employee", schema = "jurnalproject_storage")
public class Employee extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<Lesson> lessons = new ArrayList<>();

    @Builder.Default
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "office_employee", schema = "jurnalproject_storage",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "office_id")
    )
    private List<Office> offices = new ArrayList<>();
}
