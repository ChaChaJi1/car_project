package com.packt.cardatabase.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ownerid;
    private String firstname, lastname;
    public Owner(){}
    public Owner(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
    private List<Car> cars;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="car_owner", joinColumns = { @JoinColumn(name="ownerid") },
            inverseJoinColumns = { @JoinColumn(name="`id`")})
    private Set<Car> owners = new HashSet<Car>();
}