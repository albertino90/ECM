package com.datatehecm.testecm.model;

import lombok.*;

import javax.persistence.*;

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
//    private Employee manager;

}
