package org.example;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNo;
    private List<ParkingSlot> slots;
    public Floor(int floorNo)
    {
        this.floorNo=floorNo;
        this.slots = new ArrayList<>();
    }
    public void addParkingSlot(ParkingSlot slot){
        slots.add(slot);
    }
    public int getFloorNo(){
        return floorNo;
    }
    public List<ParkingSlot> getSlots(){
        return slots;
    }
}
