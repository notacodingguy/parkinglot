package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        // Create a new parking lot
        ParkingLot parkingLot = new ParkingLot("PR1234");
        parkingLot.createParkingLot();

        // Add floors to the parking lot
        Floor floor1 = new Floor(1);
        parkingLot.addFloor(floor1);

        Floor floor2 = new Floor(2);
        parkingLot.addFloor(floor2);

        // Add parking slots to the floors
        for (int i = 1; i <= 10; i++) {
            if (i == 1) {
                ParkingSlot truckSlot = new ParkingSlot(i, "Truck", floor1);
                floor1.addParkingSlot(truckSlot);
            } else if (i >= 2 && i <= 3) {
                ParkingSlot bikeSlot = new ParkingSlot(i, "Bike", floor1);
                floor1.addParkingSlot(bikeSlot);
            } else {
                ParkingSlot carSlot = new ParkingSlot(i, "Car", floor1);
                floor1.addParkingSlot(carSlot);
            }
        }

        for (int i = 1; i <= 10; i++) {
            if (i == 1) {
                ParkingSlot truckSlot = new ParkingSlot(i, "Truck", floor2);
                floor2.addParkingSlot(truckSlot);
            } else if (i >= 2 && i <= 3) {
                ParkingSlot bikeSlot = new ParkingSlot(i, "Bike", floor2);
                floor2.addParkingSlot(bikeSlot);
            } else {
                ParkingSlot carSlot = new ParkingSlot(i, "Car", floor2);
                floor2.addParkingSlot(carSlot);
            }
        }

        // Park vehicles
        Vehicle car1 = new Vehicle("Car", "ABC123", "Red");
        Ticket ticket1 = parkingLot.parkVehicle(car1);

        Vehicle bike1 = new Vehicle("Bike", "XYZ456", "Black");
        Ticket ticket2 = parkingLot.parkVehicle(bike1);

        // Unpark vehicle
        parkingLot.unparkVehicle(ticket1.getTicketId());

        // Get free and occupied slots
        int freeSlotsCount = parkingLot.getFreeSlotsCount(1, "Car");
        System.out.println("Number of free car slots on floor 1: " + freeSlotsCount);

        List<ParkingSlot> freeSlots = parkingLot.getFreeSlots(1, "Car");
        System.out.println("Free car slots on floor 1: ");
        for (ParkingSlot slot : freeSlots) {
            System.out.println("Slot " + slot.getSlotNo());
        }

        List<ParkingSlot> occupiedSlots = parkingLot.getOccupiedSlots(1, "Car");
        System.out.println("Occupied car slots on floor 1: ");
        for (ParkingSlot slot : occupiedSlots) {
            System.out.println("Slot " + slot.getSlotNo());
        }
    }
}