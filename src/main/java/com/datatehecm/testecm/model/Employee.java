package com.datatehecm.testecm.model;

import lombok.*;

import javax.persistence.*;
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
    private String last_name;
    private String first_name;
    private String middle_name;
    private String position;

//    @OneToOne(mappedBy = "manager")
//    private Organization organization;

    @OneToMany(mappedBy="author",cascade = CascadeType.ALL)
    private Set<Assignment> assignments = new HashSet<Assignment>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization__id")
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="structural_unit_id")
    private StructuralUnit structuralUnit;







}
