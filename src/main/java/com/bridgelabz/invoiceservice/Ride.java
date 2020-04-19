package com.bridgelabz.invoiceservice;

public class Ride {
    public final CabSubscriptions cabRide ;
    public double distance;
    public int time;
    public Ride(CabSubscriptions ride, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.cabRide = ride;
    }
}
