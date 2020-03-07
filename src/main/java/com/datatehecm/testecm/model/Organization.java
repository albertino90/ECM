package com.datatehecm.testecm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.bind.v2.TODO;
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

    //TODO Разобраться с добавлением директора, мб создать роли в виде таблицы

    @EqualsAndHashCode.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_manager_id")
    private Employee manager;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "organization",fetch = FetchType.EAGER, orphanRemoval = true)
    private Set <StructuralUnit> structuralUnits = new HashSet<StructuralUnit>();

    //    убрал сотрудников от орг
//    @EqualsAndHashCode.Exclude
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
//    private Set <Employee> employees  = new HashSet<Employee>();



}
