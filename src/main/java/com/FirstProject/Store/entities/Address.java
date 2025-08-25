package com.FirstProject.Store.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@ToString
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;

    @Column(nullable = false,name="city")
    private String city;

    @Column(nullable = false,name="street")
    private String street;

    @Column(nullable = false,name="state")
    private String state;

    @Column(nullable = false,name="zipcode")
    private String zipcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id")
    @ToString.Exclude
    @JsonBackReference
    private User user;
}
