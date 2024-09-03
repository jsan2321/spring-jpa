package com.jpa02.unidirectional.oneToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "uni_Employee_one_to_one")
@Table(name = "uni_Employee_one_to_one")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "parking_spot_id")
    private ParkingSpot parkingSpot;
}

// the association is established if from my current entity, I can access the other related entity
// only one of the parties (this one) can access the other entity, making the other unable to do the same