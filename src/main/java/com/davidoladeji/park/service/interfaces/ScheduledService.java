package com.davidoladeji.park.service.interfaces;

import javax.ejb.Remote;

/**
 * Created by Daveola on 3/5/2015.
 */

@Remote
public abstract interface ScheduledService {

    public abstract void performService();

    public void performCarparksUpdate();

    public void setFamilyAvailable();

    public void setDisabledAvailable();

    public void deactivateBookings();
}
