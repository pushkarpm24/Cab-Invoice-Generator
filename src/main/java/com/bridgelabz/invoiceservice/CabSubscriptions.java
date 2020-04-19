package com.bridgelabz.invoiceservice;

public enum CabSubscriptions {
    NORMAL(1,10.0,5.0),
    PREMIUM(2,15.0,20.0);

    private  final int COST_PER_TIME;
    private final double MINIMUM_COST_PER_KILOMETER;
    private final double MINIMUM_FARE;

    CabSubscriptions(int COST_PER_TIME, double MINIMUM_COST_PER_KILOMETER, Double MINIMUM_FARE) {
        this.COST_PER_TIME = COST_PER_TIME;
        this.MINIMUM_COST_PER_KILOMETER = MINIMUM_COST_PER_KILOMETER;
        this.MINIMUM_FARE = MINIMUM_FARE;
    }

    public double calculateFare( Ride ride) {
        Double RideCost = ride.distance * MINIMUM_COST_PER_KILOMETER + ride.time * COST_PER_TIME;
        return Math.max(RideCost, MINIMUM_FARE);
    }
}
