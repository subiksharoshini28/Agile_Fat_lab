package com.hotel.booking;

public class Room {
    private final int roomId;
    private boolean isBooked;

    public Room(int roomId) {
        this.roomId = roomId;
        this.isBooked = false;
    }

    public int getRoomId() { return roomId; }
    public synchronized boolean isBooked() { return isBooked; }
    public synchronized void setBooked(boolean booked) { this.isBooked = booked; }
}