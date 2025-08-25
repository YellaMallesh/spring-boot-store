package com.FirstProject.Store.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="profiles")
public class Profile {
    @Id
    @Column(name="id")
    private Long Id;

    @Column(nullable = false,name="bio")
    private String bio;

    @Column(nullable = false,name="phone_number")
    private String phoneNumber;

    @Column(nullable = false,name="loyalty_points")
    private Integer loyaltyPoints;

    @Column(nullable = false,name="date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @MapsId
    @ToString.Exclude
    @JsonBackReference
    private User users;
}
