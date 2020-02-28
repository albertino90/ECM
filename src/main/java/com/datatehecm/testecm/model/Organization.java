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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "organization")
    private Set <StructuralUnit> structuralUnits = new HashSet<StructuralUnit>();
//    private Employee manager;

}
