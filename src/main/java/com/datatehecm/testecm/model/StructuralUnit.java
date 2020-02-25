package com.datatehecm.testecm.model;

import lombok.*;

import javax.persistence.*;

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
    private String name;
    private String email;
//    private Employee manager;


}
