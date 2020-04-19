package com.bridgelabz.invoiceservice;

public class InvoiceService {



    private RideRepository rideRepository;
    double totalFare = 0;

    public void setRideRepository(RideRepository rideRepository) {
        this.rideRepository = rideRepository;

    }

    public double calculateFareForNormalAndPrime (Ride[] rides) {
        for (Ride ride : rides) {
            totalFare += ride.cabRide.calculateFare(ride);
        }
        return totalFare;
    }


    public  InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare +=  ride.cabRide.calculateFare(ride);
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
