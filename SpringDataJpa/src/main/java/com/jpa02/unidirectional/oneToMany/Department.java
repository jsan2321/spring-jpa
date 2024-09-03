package com.jpa02.unidirectional.oneToMany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "uni_Department_one_to_many")
@Table(name = "uni_Department_one_to_many")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "department_id")
    private List<Employee> employeeList;
}

// entity that has the 'one' in the relationship