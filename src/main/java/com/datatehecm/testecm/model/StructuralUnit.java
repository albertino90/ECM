package com.datatehecm.testecm.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "structuralUnits")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class StructuralUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "structuralUnit_manager_id")
    private Employee manager;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization__id")
    private Organization organization;

    @OneToMany(mappedBy="structuralUnit",cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<Employee>();


}
