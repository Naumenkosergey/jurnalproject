package com.itacademy.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@ToString(exclude = {"user", "groupa", "status", "marks"})

@Entity
@Table(name = "student", schema = "jurnalproject_schema")
public class Student extends BaseEntity<Long> {

    @Column(name = "sername")
    private String sername;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymich;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groupa groupa;

    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Mark> marks = new ArrayList<>();
}