package com.davidoladeji.park.model;

import com.davidoladeji.park.service.util.MyTimeDateUtil;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Daveola on 3/3/2015.
 */
@Entity(name = "search")
@Table(name = "search")
public class Search implements Serializable {

    // @PersistenceContext(type = PersistenceContextType.EXTENDED)

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long airportid;

    /**
     * Date and TIme car will be dropped in carpark
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    private Date traveldate;

    @DateTimeFormat(pattern = "HH:ss:mm")
    private Date traveltime;

    /**
     * Date and TIme car will leave carpark
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    private Date travelenddate;

    @DateTimeFormat(pattern = "HH:ss:mm")
    private Date travelendtime;

    /**
     * Number of days, calculated from
     * CurrentDateTime Class
     */
    private int numdays;

    private Long spaceTypeId;


    public Search() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAirportid() {
        return airportid;
    }

    public void setAirportid(Long airportid) {
        this.airportid = airportid;
    }

    public Date getTraveldate() {
        return traveldate;
    }

    public void setTraveldate(Date traveldate) {
        this.traveldate = traveldate;
    }

    public Date getTraveltime() {
        return traveltime;
    }

    public Date setTraveltime(Date traveltime) {
        this.traveltime = traveltime;
        return traveltime;
    }

    public Date getTravelenddate() {
        return travelenddate;
    }

    public void setTravelenddate(Date travelenddate) {
        this.travelenddate = travelenddate;
    }

    public Date getTravelendtime() {
        return travelendtime;
    }

    public void setTravelendtime(Date travelendtime) {
        this.travelendtime = travelendtime;
    }

    public int getNumdays() {
        return numdays;
    }


    public void setNumdays(int numdays) {

        this.numdays = numdays;
    }

    public Long getSpaceTypeId() {
        return spaceTypeId;
    }

    public void setSpaceTypeId(Long spaceTypeId) {
        this.spaceTypeId = spaceTypeId;
    }

    @PrePersist
    public void updateNumdays() {

        MyTimeDateUtil myTimeDateUtil = new MyTimeDateUtil();

        LocalDate traveldate = myTimeDateUtil.convertUtilDateToLocalDate(this.getTraveldate());
        LocalDate travelenddate = myTimeDateUtil.convertUtilDateToLocalDate(this.getTravelenddate());

        numdays = Days.daysBetween(traveldate, travelenddate).getDays();

        this.setNumdays(numdays);
    }


}
