package com.datatehecm.testecm.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String last_name;

    @NotNull
    private String first_name;

    @NotNull
    private String middle_name;

    @NotNull
    private String position;

    @OneToMany(mappedBy="author",cascade = CascadeType.ALL)
    private Set<Assignment>author_of_assignments = new HashSet<Assignment>();

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization__id")
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="structural_unit_id")
    private StructuralUnit structuralUnit;

    @ManyToMany(mappedBy = "employee_contractor",fetch = FetchType.EAGER)
    private Set<Assignment> assignments_contractor = new HashSet<Assignment>();







}
