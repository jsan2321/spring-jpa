package com.jpa01.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Coach { // 1 coach to 1 club

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10, nullable = false, unique = true)
    private String name;

    @Column(name = "last_name", columnDefinition = "VARCHAR(100)")
    private String lastName; // java uses camelcase, SQL uses snake case

    private String nationality;
    private Integer age;
}
