package com.davidoladeji.park.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Daveola on 2/24/2015.
 */
@Entity(name = "carpark_space")
@Table(name = "carpark_space")
public class CarparkSpace implements Serializable {

    private static final long serialVersionUID = -3101538419759959856L;

    @ManyToOne
    @JoinTable(name = "carpark_carpark_space",
            joinColumns = {@JoinColumn(name = "carpark_space_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "carpark_id", referencedColumnName = "id")})
    private Carpark carpark;


    @OneToOne
    private SpaceType spaceType;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public CarparkSpace() {
    }

    @Column(name = "bookingstatus")
    private boolean booked;


    @OneToOne
    private Booking booking;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }


    public SpaceType getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(SpaceType spaceType) {
        this.spaceType = spaceType;
    }

    public Carpark getCarpark() {
        return carpark;
    }

    public void setCarpark(Carpark carpark) {
        this.carpark = carpark;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarparkSpace that = (CarparkSpace) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
