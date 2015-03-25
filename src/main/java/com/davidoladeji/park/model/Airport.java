package com.davidoladeji.park.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Daveola on 2/20/2015.
 */


@Entity(name = "airport")
@Table(name = "airport")
public class Airport implements Serializable {

    //@PersistenceContext(type = PersistenceContextType.EXTENDED)

    private static final long serialVersionUID = 5018455413693417595L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "address")
    private String address;


    @Column(name = "postcode")
    private String postcode;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "airport_carpark",
            joinColumns = {@JoinColumn(name = "airport_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "carpark_id", referencedColumnName = "id")})
    private List<Carpark> carpark;

    public Airport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Transactional
    public List<Carpark> getCarpark() {
        return carpark;
    }

    public void setCarpark(List<Carpark> carpark) {
        this.carpark = carpark;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (id != airport.id) return false;
        if (address != null ? !address.equals(airport.address) : airport.address != null) return false;
        if (name != null ? !name.equals(airport.name) : airport.name != null) return false;
        if (postcode != null ? !postcode.equals(airport.postcode) : airport.postcode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (carpark != null ? carpark.hashCode() : 0);
        return result;
    }
}
