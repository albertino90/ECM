package com.datatehecm.testecm.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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

    @NotNull
    private String headline;

    @NotNull
    private String text;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Employee author;

    @NotNull
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set <Employee> employee_contractor = new HashSet<Employee>();

//    срок исполнения
//признак контрольности
//    признак исполнения



}
