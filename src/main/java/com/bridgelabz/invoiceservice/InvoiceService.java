package com.bridgelabz.invoiceservice;

public class InvoiceService {

    private static final double MINIMUM_COST_PER_KILOMETER_NORMAL = 10 ;
    private static final int COST_PER_TIME_NORMAL = 1;
    private static final double MINIMUM_FARE_NORMAL = 5;

    private static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15 ;
    private static final int COST_PER_TIME_PREMIUM = 2;
    private static final double MINIMUM_FARE_PREMIUM = 20;


    private RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();

    }

    public double calculateFare(double distance, int time, Ride.RideType rideType) {
        double totalFare = 0;
        if(rideType == Ride.RideType.NORMAL) {
            totalFare =  distance * MINIMUM_COST_PER_KILOMETER_NORMAL + time * COST_PER_TIME_NORMAL;
            return Math.max(totalFare, MINIMUM_FARE_NORMAL);
        }
        totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
        return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
        }



    public  InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time, ride.rideType);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

}
