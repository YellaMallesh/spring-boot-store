package com.FirstProject.Store.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @EqualsAndHashCode.Include
    private Long id;


    @Column(nullable = false,name="name")
    private String name;

    @Column(nullable = false,name="email")
    private String email;

    @Column(nullable = false,name="password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    public List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address){
        addresses.remove(address);
        address.setUser(null);
    }

    public void addTags(String tagName){
        var tag = new Tag(tagName);
        tags.add(tag);
        tag.getUsers().add(this);
    }

    @ManyToMany
    @JoinTable(
            name="user_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    @JsonIgnore
    private Set<Tag> tags = new HashSet<>();



    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )

    public Set<Product> wishlist = new HashSet<>();

    public void addFavoriteProduct(Product product) {
        wishlist.add(product);
    }

    @Override
        public String toString(){
        return getClass().getSimpleName() + "(" +
                "id = " + id + "," +
                "name = "+ name + "," +
                "email = " + email + "," +
                "password = " + password + ")";
        }
}
