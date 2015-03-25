package com.davidoladeji.park.service.util;

import org.joda.time.Days;
import org.joda.time.LocalDate;


/**
 * Created by Daveola on 3/1/2015.
 * Every space available has a base or regular price
 * But the price is affected by various
 * factors which the methods following take
 * care of.
 */
public class Pricing {


    /**
     * A method to calculate the price of a booking based
     * on the type of space being booked
     *
     * @param price
     * @param spacetype
     * @return
     */
    public static double getPriceByType(double price, int spacetype) {

        double newprice = 0.00;

        if (spacetype == 1) {
            //Regular Space Type
            //do nothing
            newprice = price;

        } else if (spacetype == 2) {
            //Family
            newprice = price + (price * 0.30);

        } else if (spacetype == 3) {

            // Disabled Discount
            newprice = price - (price * 0.20);

        }

        return newprice;
    }


    /**
     * A method to calculate the price of a booking by applying
     * a discount depending on the number of days being booked
     *
     * @param price
     * @param arrivaldate
     * @param departdate
     * @return
     */
    public static double getPriceByBookingNumDays(double price, LocalDate arrivaldate, LocalDate departdate) {

        double newprice = 0.0;
        int days = Days.daysBetween(arrivaldate, departdate).getDays();

        if (days >= 5) {
            //Give Discounts for bookings of 5 days and more
            newprice = price - (price * 0.25);
        }else{
            newprice = price;
        }

        return newprice;
    }

    /**
     * A method to apply a discount based on how far ahead
     * a booking is being done.
     *
     * @param price
     * @param arrivaldate
     * @return
     */

    public static double getPriceByHowAdvance(double price, LocalDate arrivaldate) {

    	double newprice = 0.0;
        int days = Days.daysBetween(LocalDate.now(), arrivaldate).getDays();
        System.out.println("Date diff: "+ days);
        if (days >= 5) {
            //Give Discounts for bookings of 5 days and more
            newprice = price - (price * 0.25);
        }else{
            newprice = price;
        }

        return newprice;
    }

    /**
     * Gets the total trip price.
     *
     * @param price the price
     * @param arrivaldate the arrivaldate
     * @param departdate the departdate
     * @return the total trip price
     */
    public static double getTotalTripPrice(double price, LocalDate arrivaldate, LocalDate departdate) {


        int days = Days.daysBetween(arrivaldate, departdate).getDays();
        return price * days;
    }

}
