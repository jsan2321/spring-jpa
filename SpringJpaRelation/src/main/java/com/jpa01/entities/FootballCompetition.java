package com.jpa01.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FootballCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "name", columnDefinition = "VARCHAR(300)", nullable = false)
    private String name;

    @Column(name = "cuantity_price")
    private int cuantityPrice;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;

    @ManyToMany(targetEntity = Club.class, fetch = FetchType.LAZY) // if two intermediary tables are created, delete (this) one
    private List<Club> clubs;
}