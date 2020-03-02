package com.datatehecm.testecm.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "organizations")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String legal_address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_manager_id")
    private Employee manager;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "organization")
    private Set <StructuralUnit> structuralUnits = new HashSet<StructuralUnit>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "organization")
    private Set <Employee> employees  = new HashSet<Employee>();



}
