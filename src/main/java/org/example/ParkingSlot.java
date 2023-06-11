package org.example;

public class ParkingSlot {
    private int slotNo;
    private String vehicleType;
    private boolean availability;
    private Vehicle vehicle;
    private Floor floor;
    public ParkingSlot(int slotNo, String vehicleType, Floor floor){
        this.slotNo=slotNo;
        this.vehicleType=vehicleType;
        this.availability=true;
        this.vehicle=vehicle;
        this.floor=floor;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Floor getFloor() {
        return floor;
    }
    public void assignVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
        this.availability=false;
    }
    public void removeVehicle()
    {
        this.vehicle=null;
        this.availability=true;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable() {
        return availability;
    }
}
