package com.bridgelabz.invoiceservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    Ride[] rides=null;
    InvoiceService invoiceService=null;
    InvoiceSummary expectedInvoiceSummary = null;
    private RideRepository rideRepository = null;

    @Before
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
        rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[]{
                new Ride(CabSubscriptions.NORMAL, 2.0, 5),
                new Ride(CabSubscriptions.PREMIUM, 0.1, 1)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
    }

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double fare = invoiceService.calculateFareForNormalAndPrime(rides);
        Assert.assertEquals(45, fare, 0.0);

    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary() {

        String userId = "asd";
        Ride[] rides = { new Ride(CabSubscriptions.NORMAL,2.0, 5 ),
                new Ride(CabSubscriptions.PREMIUM,0.1, 1 )};
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,45.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }
}
