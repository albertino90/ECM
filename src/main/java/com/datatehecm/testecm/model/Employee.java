package com.datatehecm.testecm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String last_name;

    @NotNull
    private String first_name;

    @NotNull
    private String middle_name;

    @NotNull
    private String position;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy="author",cascade = CascadeType.ALL)
    private Set<Assignment>author_of_assignments = new HashSet<Assignment>();

//    @NotNull
//    @EqualsAndHashCode.Exclude
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "organization__id")
//    private Organization organization;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="structural_unit_id")
    private StructuralUnit structuralUnit;

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "employee_contractor",fetch = FetchType.EAGER)
    private Set<Assignment> assignments_contractor = new HashSet<Assignment>();

    @Override
    public String toString() {
        return last_name+" "+first_name+" "+middle_name;
    }
}
