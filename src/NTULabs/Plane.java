package NTULabs;

import java.util.Arrays;

public class Plane {
    public PlaneSeat[] seat;
    public static int CONST = 12;
    public int numEmptySeat;

    public Plane(){
        this.seat = new PlaneSeat[CONST];
        for (int i = 0; i < CONST; i++){
            this.seat[i] = new PlaneSeat();
        }
        this.numEmptySeat = CONST;
    }
    public PlaneSeat[] sortSeats(){
        PlaneSeat[] new_version = new PlaneSeat[CONST];
        for (int i = 0; i < CONST; i++){
            new_version[i] = this.seat[i];
        }
        Arrays.sort(new_version);
        return new_version;
    }
    public void showNumEmptySeats(){
        System.out.println("There are " + this.numEmptySeat+" empty seats");
    }
    public void showEmptySeat(){
        System.out.println("The following seats are empty:");
        for (int i = 1; i <= CONST; i++){
            if (!this.seat[i - 1].isOccupied()){
                System.out.println("SeatID " + i);
            }
        }
    }
    public void showAssignedSeat(){
        System.out.println("The seat assignments are as follow:");
        for (int i = 1; i <= CONST; i++){
            if (this.seat[i - 1].isOccupied()){
                System.out.println("SeatID " + i + " assigned to CustomerID " + this.seat[i-1].getCustomerId());
            }
        }
    }
    public void assignSeat(int seatId, int customerId){
        if (this.seat[seatId - 1].isOccupied()){
            System.out.println("Seat already assigned to a customer.");
        }
        else{
            this.seat[seatId - 1] = new PlaneSeat(seatId, customerId, true);
            --this.numEmptySeat;
            System.out.println("Seat Assigned!");
        }
    }
    public void unAssignSeat(int seatId){
        this.seat[seatId - 1].unAssigned();
        ++this.numEmptySeat;
    }
}
