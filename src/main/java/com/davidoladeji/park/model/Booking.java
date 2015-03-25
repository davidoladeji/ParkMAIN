package com.davidoladeji.park.model;


import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Daveola on 2/24/2015.
 */

@Entity(name = "booking")
@Table(name = "booking")
public class Booking implements Serializable {

    //@PersistenceContext(type = PersistenceContextType.EXTENDED)

    private static final long serialVersionUID = 3364077449616825147L;

    /**
     * For JPARepository the id needs to be a long
     * The hashcode id needs to be an int hence
     * the business layer id
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private long receiptno;


    @Column(name = "base_price") //e.g. price in pounds
    private double base_price;


    @Column(name = "destination_price")
    private double destinationPrice;

    @NotNull(message = "Please enter arrival time")
    @Column(name = "arrival_time")
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;

    @Future(message = "You can only pick a date in future")
    @Column(name = "arrival_date")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;

    @NotNull(message = "Please enter departure time")
    @Column(name = "departure_time")
    @Temporal(TemporalType.TIME)
    private Date departureTime;

    @Future(message = "You can only pick a date in future")
    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private Date departureDate;


    @Column(name = "flight_number")
    private String flightNumber;


    @Column(name = "car_model")
    private String carModel;

    @Column(name = "car_body")
    private String carBody;


    @Column(name = "car_registration")
    private String carRegistration;


    private boolean active;

    @OneToOne
    private SpaceType spaceType;

    @OneToOne
    private CarparkSpace carparkSpace;


    @ManyToOne
    private Account account;
    
    @Transient
    private double total;
    
    @Transient
    private String currencyIn;


    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getReceiptno() {
        return receiptno;
    }

    public void setReceiptno() {

        long bookingcodeno = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;

        this.receiptno = bookingcodeno;
    }


    public double getBase_price() {
        return base_price;
    }

    public void setBase_price(double totalPounds) {
        this.base_price = totalPounds;
    }


    public double getDestinationPrice() {
        return destinationPrice;
    }

    public void setDestinationPrice(double destinationPrice) {
        this.destinationPrice = destinationPrice;
    }


    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }


    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }


    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }


    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarBody() {
        return carBody;
    }

    public void setCarBody(String carBody) {
        this.carBody = carBody;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @XmlTransient // bidirectional relation causes a loop for XML serialization;
    public SpaceType getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(SpaceType spaceType) {
        this.spaceType = spaceType;
    }

    @XmlTransient // bidirectional relation causes a loop for XML serialization;
    public CarparkSpace getCarparkSpace() {
        return carparkSpace;
    }

    public void setCarparkSpace(CarparkSpace carparkSpace) {
        this.carparkSpace = carparkSpace;
    }

    @XmlTransient // bidirectional relation causes a loop for XML serialization;
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (id != null ? !id.equals(booking.id) : booking.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    public int getNumOfDays(){
    	
    	DateTime aTime = new  DateTime(arrivalDate);
    	DateTime dTime = new  DateTime(departureDate);
    	System.out.println(aTime + " " + dTime);
    	
    	int d = Days.daysBetween(aTime, dTime).getDays();
    	
    	return d;
    }

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getCurrencyIn() {
		return currencyIn;
	}

	public void setCurrencyIn(String currencyIn) {
		this.currencyIn = currencyIn;
	}


}
