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
    private String text;

    @ManyToOne
    @JoinColumn(name = "author_employee_id")
    private Employee author;

    //    private Employee responsible_employee;


}
