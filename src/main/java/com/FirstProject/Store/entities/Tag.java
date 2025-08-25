package com.FirstProject.Store.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name="name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    @ToString.Exclude
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Tag(String name){
        this.name=name;
    }

}
