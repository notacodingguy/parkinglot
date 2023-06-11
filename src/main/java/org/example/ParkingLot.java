package org.example;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String id;
    private List<Floor> floors;
    public ParkingLot(String id)
    {
        this.id=id;
        this.floors = new ArrayList<>();
    }
    public void createParkingLot()
    {
        System.out.println("Parking lot created with ID: "+ id);
    }
    public void addFloor(Floor floor)
    {
        floors.add(floor);
        System.out.println("Floor" + floor);
    }
    public ParkingSlot findAvailableSlot(String vehicletype)
    {
        for(Floor floor: floors)
        {
            List<ParkingSlot> slots= floor.getSlots();
            for(ParkingSlot slot: slots)
            {
                if(slot.getVehicleType().equalsIgnoreCase(vehicletype)){
                    return slot;
            }
            }
        }
        return null;
    }
    public Ticket parkVehicle(Vehicle vehicle) {
        String vehicleType = vehicle.getType();
        ParkingSlot slot = findAvailableSlot(vehicleType);
        if (slot != null) {
            slot.assignVehicle(vehicle);
            String ticketId = id + "_" + slot.getFloor().getFloorNo() + "_" + slot.getSlotNo();
            Ticket ticket = new Ticket(ticketId, slot, vehicle);
            System.out.println("Vehicle with registration number " + vehicle.getRegistrationNumber() +
                    " parked at slot " + slot.getSlotNo() + " on floor " + slot.getFloor().getFloorNo());
            return ticket;
        } else {
            System.out.println("No available slot found for vehicle type: " + vehicleType);
            return null;
        }
    }

    public void unparkVehicle(String ticketId) {
        String[] ticketParts = ticketId.split("_");
        if (ticketParts.length == 3) {
            String parkingLotId = ticketParts[0];
            int floorNo = Integer.parseInt(ticketParts[1]);
            int slotNo = Integer.parseInt(ticketParts[2]);

            if (parkingLotId.equals(id)) {
                Floor floor = floors.get(floorNo - 1);
                List<ParkingSlot> slots = floor.getSlots();
                if (slotNo >= 1 && slotNo <= slots.size()) {
                    ParkingSlot slot = slots.get(slotNo - 1);
                    if (!slot.isAvailable()) {
                        Vehicle vehicle = slot.getVehicle();
                        slot.removeVehicle();
                        System.out.println("Vehicle with registration number " + vehicle.getRegistrationNumber() +
                                " unparked from slot " + slotNo + " on floor " + floorNo);
                    } else {
                        System.out.println("Invalid ticket ID or vehicle already unparked.");
                    }
                } else {
                    System.out.println("Invalid slot number.");
                }
            } else {
                System.out.println("Invalid parking lot ID.");
            }
        } else {
            System.out.println("Invalid ticket ID format.");
        }
    }
    public int getFreeSlotsCount(int floorNo, String vehicleType) {
        int count = 0;
        Floor floor = floors.get(floorNo - 1);
        List<ParkingSlot> slots = floor.getSlots();
        for (ParkingSlot slot : slots) {
            if (slot.getVehicleType().equalsIgnoreCase(vehicleType) && slot.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public List<ParkingSlot> getFreeSlots(int floorNo, String vehicleType) {
        List<ParkingSlot> freeSlots = new ArrayList<>();
        Floor floor = floors.get(floorNo - 1);
        List<ParkingSlot> slots = floor.getSlots();
        for (ParkingSlot slot : slots) {
            if (slot.getVehicleType().equalsIgnoreCase(vehicleType) && slot.isAvailable()) {
                freeSlots.add(slot);
            }
        }
        return freeSlots;
    }
    public List<ParkingSlot> getOccupiedSlots(int floorNo, String vehicleType) {
        List<ParkingSlot> occupiedSlots = new ArrayList<>();
        Floor floor = floors.get(floorNo - 1);
        List<ParkingSlot> slots = floor.getSlots();
        for (ParkingSlot slot : slots) {
            if (slot.getVehicleType().equalsIgnoreCase(vehicleType) && !slot.isAvailable()) {
                occupiedSlots.add(slot);
            }
        }
        return occupiedSlots;
    }
}
