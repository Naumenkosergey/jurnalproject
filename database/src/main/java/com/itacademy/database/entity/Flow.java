package com.itacademy.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"groupas, flow"})

@Entity
@Table(name = "flow", schema = "jurnalproject_schema")
public class Flow extends BaseEntity<Long> {

    @JoinColumn(name = "name")
    private String name;

    @OneToMany(mappedBy = "flow", fetch = FetchType.EAGER)
    private Set<Groupa> groupas = new HashSet<>();

    @OneToMany(mappedBy = "flow", fetch = FetchType.EAGER)
    private Set<Subject> subjects = new HashSet<>();

}
