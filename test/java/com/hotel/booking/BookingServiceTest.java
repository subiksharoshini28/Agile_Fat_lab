package com.hotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookingServiceTest {
    private BookingService service;

    @BeforeEach
    void setUp() {
        service = new BookingService();
    }

    @Test
    void testBookingSuccess() {
        String result = service.bookRoom(101);
        assertTrue(result.contains("Success"));
    }

    @Test
    void testDoubleBookingPrevention() {
        service.bookRoom(101);
        String result = service.bookRoom(101);
        assertTrue(result.contains("Failure"));
    }

    @Test
    void testCancelBooking() {
        service.bookRoom(105);
        String result = service.cancelBooking(105);
        assertTrue(result.contains("Success"));
        assertTrue(service.getAvailableRooms().contains(105));
    }
}