package NTULabs;

public class PlaneSeat implements Comparable<PlaneSeat>{
    public int seatID, customerId;
    public boolean assigned;
    public PlaneSeat(){
        this.assigned = false;
    }
    public PlaneSeat(int seatID, int customerId, boolean assigned){
        this.seatID = seatID;
        this.customerId = customerId;
        this.assigned = assigned;
    }

    public int getSeatID() {
        return this.seatID;
    }

    public int getCustomerId() {
        return this.customerId;
    }
    public boolean isOccupied(){
        return this.assigned;
    }
    public void assign(int customerId){
        this.customerId = customerId;
    }
    public void unAssigned(){
        this.assigned = false;
    }

    @Override
    public int compareTo(PlaneSeat o) {
        return this.customerId - o.customerId;
    }
}
