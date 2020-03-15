package com.datatehecm.testecm.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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

    //TODO флаги переходы...?

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startAssignment = LocalDateTime.now();

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endAssignment;

    @NotNull
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Employee author;

    @NotNull
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    private Set <Employee> employee_contractor = new HashSet<Employee>();




}
