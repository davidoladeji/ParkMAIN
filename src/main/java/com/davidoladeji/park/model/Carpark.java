package com.davidoladeji.park.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Daveola on 2/20/2015.
 */


@Entity(name = "carpark")
@Table(name = "carpark")
public class Carpark implements Serializable {

    //@PersistenceContext(type = PersistenceContextType.EXTENDED)

    private static final long serialVersionUID = -1655523302320149312L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


   // @Size(min = 1, max = 8)
    @Column(name = "codename", nullable = false, unique = true, length = 8)
    private String codename;

   // @Size(min = 1, max = 20)
    @Column(name = "mobile")
    private String mobile;


    @Column(name = "capacity")
    private int capacity;

   // @Size(min = 1, max = 10)
    @Column(name = "capacitydisabled")
    private int capacitydisabled;

    @Column(name = "capacityfamily")
    private int capacityfamily;

    @Column(name = "spacesavailable")
    private int spacesavailable;

    @Column(name = "disabledavailable")
    private int disabledavailable;


    @Column(name = "familyavailable")
    private int familyavailable;


    @Column(name = "price")
    private double regularprice;

    @Column(name = "available")
    private boolean available;

    @OneToMany(fetch=FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "carpark_carpark_space",
            joinColumns = {@JoinColumn(name = "carpark_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "carpark_space_id", referencedColumnName = "id")})
    private List<CarparkSpace> carparkSpaces;



    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "airport_carpark",
            joinColumns = {@JoinColumn(name = "carpark_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "airport_id", referencedColumnName = "id")})
    private Airport airport;


    public Carpark() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacitydisabled() {
        return capacitydisabled;
    }

    public void setCapacitydisabled(int capacitydisabled) {
        this.capacitydisabled = capacitydisabled;
    }

    public int getCapacityfamily() {
        return capacityfamily;
    }

    public void setCapacityfamily(int capacityfamily) {
        this.capacityfamily = capacityfamily;
    }

    public int getSpacesavailable() {
        return spacesavailable;
    }

    public void setSpacesavailable(int spacesavailable) {
        this.spacesavailable = spacesavailable;
    }

    public void setSpacesavailable() {
        int spacesavailable = 0;
        for (int i = 1; i < this.getCarparkSpaces().size() - 1; i++) {

            if (!this.getCarparkSpaces().iterator().next().isBooked()) {
                spacesavailable++;
            }
            this.getCarparkSpaces().iterator().next();
        }


        this.spacesavailable = spacesavailable;
    }

    /**
     * based on the number of available space this method determines
     * if bookings can be made at a carpark
     *
     * @return
     */
    public boolean isAvailable() {
        return available;
    }


    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getRegularprice() {
        return regularprice;
    }

    public void setRegularprice(double regularprice) {
        this.regularprice = regularprice;
    }

    @XmlTransient
    public int getDisabledavailable() {
        return disabledavailable;
    }

    public void setDisabledavailable(int disabledavailable) {
        this.disabledavailable = disabledavailable;
    }

    public void setDisabledavailable() {
        int disabledavailable = 0;

        for (int i = 0; i < this.getCarparkSpaces().size(); i++) {

            if (this.getCarparkSpaces().iterator().next().getSpaceType().getName().equalsIgnoreCase("disabled")) {
                disabledavailable++;
            }
            this.getCarparkSpaces().iterator().next();
        }

        this.disabledavailable = disabledavailable;

    }

    @XmlTransient
    public int getFamilyavailable() {
        return familyavailable;
    }

    public void setFamilyavailable(int familyavailable) {
        this.familyavailable = familyavailable;
    }

    public void setFamilyavailable() {
        int familyavailable = 0;

        for (int i = 0; i < this.getCarparkSpaces().size(); i++) {

            if (this.getCarparkSpaces().iterator().next().getSpaceType().getName().equalsIgnoreCase("family")) {
                familyavailable++;
            }
            this.getCarparkSpaces().iterator().next();
        }
        this.familyavailable = familyavailable;
    }

    @XmlTransient
    public List<CarparkSpace> getCarparkSpaces() {
        return carparkSpaces;
    }

    public void setCarparkSpaces(List<CarparkSpace> carparkSpaces) {
        this.carparkSpaces = carparkSpaces;
    }

    @XmlTransient
    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }


    /**
     * Set some things to ensure overbooking doesn't occur or unavailable
     * carparks displayed as available
     */


    @PostLoad
    public void doPostLoad() {
        this.setSpacesavailable();
        if (this.getSpacesavailable() == 0) {
            this.setAvailable(false);
        } else if (this.getSpacesavailable() >= 1) {
            this.setAvailable(true);
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carpark carpark = (Carpark) o;

        if (id != null ? !id.equals(carpark.id) : carpark.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
