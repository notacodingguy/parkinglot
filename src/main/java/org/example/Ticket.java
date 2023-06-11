package org.example;

public class Ticket {
    private String ticketId;
    private ParkingSlot slot;
    private Vehicle vehicle;
    public Ticket(String ticketId, ParkingSlot slot, Vehicle vehicle)
    {
        this.ticketId=ticketId;
        this.slot=slot;
        this.vehicle=vehicle;
    }
    public String getTicketId() {
        return ticketId;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
