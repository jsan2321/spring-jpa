package com.jpa01.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Club { // 1 club to 1 coach

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "id_coach")
    private Coach coach; // foreign key

    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY)
    //@OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club")
    private List<Player> players; // one club has many players

    @ManyToOne(targetEntity = FootballAssociation.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private FootballAssociation footballAssociation;

    @ManyToMany(targetEntity = FootballCompetition.class, fetch = FetchType.LAZY)
    @JoinTable(name = "club_competition", joinColumns = @JoinColumn(name = "club"), inverseJoinColumns = @JoinColumn(name = "competition")) // (intermediary table name, this foreign key name, the other foreign key name)
    private List<FootballCompetition> footballCompetitions;
}

// One to One
// by querying the Club object, you can find out which coach is assigned to it - then the foreign key should be declared in this class
// by querying the Coach object, you can find out which team is assigned to it - then the foreign key should be declared in Coach class

// One to Many
// a team has many players, but a player only belongs to one team
// here the ID of the One entity goes to the Many entity as a foreign key

// Many to One
// a team belongs to a (football) association, which manages many (football) teams

// Many to Many
// a team plays in many competitions, in which many teams participate