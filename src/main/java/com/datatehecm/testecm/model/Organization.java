package com.datatehecm.testecm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Column(unique=true)
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String legal_address;

    @EqualsAndHashCode.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_manager_id")
    private Employee manager;

//    @JsonIgnoreProperties("organization")
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
    //    private Set <StructuralUnit> structuralUnits;
    private Set <StructuralUnit> structuralUnits = new HashSet<StructuralUnit>();
//    убрал сотрудников от орг
//    @EqualsAndHashCode.Exclude
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
//    private Set <Employee> employees  = new HashSet<Employee>();



}
