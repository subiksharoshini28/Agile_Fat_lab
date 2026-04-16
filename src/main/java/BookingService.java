package com.hotel.booking;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BookingService {
    private final Map<Integer, Room> rooms = new ConcurrentHashMap<>();

    public BookingService() {
        for (int i = 101; i <= 110; i++) {
            rooms.put(i, new Room(i));
        }
    }

    public synchronized String bookRoom(int roomId) {
        Room room = rooms.get(roomId);
        if (room == null) return "FAILED: Invalid Room ID.";
        if (room.isBooked()) return "FAILED: Room " + roomId + " already booked.";
        room.setBooked(true);
        return "SUCCESS: Room " + roomId + " booked.";
    }

    public synchronized String cancelBooking(int roomId) {
        Room room = rooms.get(roomId);
        if (room == null) return "FAILED: Invalid Room ID.";
        if (!room.isBooked()) return "FAILED: Room " + roomId + " is not booked.";
        room.setBooked(false);
        return "SUCCESS: Room " + roomId + " cancelled.";
    }

