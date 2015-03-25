package com.davidoladeji.park.model;


import com.davidoladeji.park.service.util.Calculator;
import com.davidoladeji.park.service.util.Scrabbler;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "account")
@Table(name = "account")
public class Account implements Serializable {


    private static final long serialVersionUID = 6253515390414044969L;

    @OneToOne()
    Role userRole;


    @OneToMany
    List<Booking> booking;


    @ManyToOne
    Gender gender;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;


    @Column(name = "password")
    private String password;


    @Column(name = "dob")
    private Date dob;

    @Size(min = 1, max = 20)
    @Column(name = "mobile")
    private String mobile;

    @Column(name = "address")
    private String address;

    @Column(name = "company")
    private String company;

    @Column(name = "manager")
    private String manager;

    @AssertTrue
    @Column(name = "enabled", nullable = true)
    private boolean enabled;

    @Column(name = "profilecompleteness")
    private double profilecompleteness;


    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        this.username = this.getEmail();
        return username;
    }


    public void setUsername() {
        this.username = this.getEmail();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.trim();
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Scrabbler scrabbler = new Scrabbler();
        this.password = scrabbler.encrypt(password);
    }


    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setProfilecompleteness(double profilecompleteness) {
        this.profilecompleteness = profilecompleteness;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public double getProfilecompleteness() {
        Calculator calculator = new Calculator();
        profilecompleteness = calculator.calcProfileCompleteness(this);
        return profilecompleteness;
    }


    public void setProfilecompleteness() {
        this.profilecompleteness = getProfilecompleteness();
    }

    @PostLoad
    public void postLoadSetData() {
        setProfilecompleteness();
        setUsername();
    }

    @PrePersist
    public void preLoadSetData() {
        setUsername();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != null ? !id.equals(account.id) : account.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
