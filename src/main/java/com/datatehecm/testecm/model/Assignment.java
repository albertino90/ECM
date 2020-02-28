package com.datatehecm.testecm.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "assignments")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Assignment {

    @Id
    @GeneratedValue
    private Long id;
    private String headline;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee author;

//    private Employee responsible_employee;
    private String text;


}
