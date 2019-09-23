package NTULabs;

import java.util.Scanner;

public class PlaneApp {
    public static void main(String[] args) {
        int seatId, CustomerID;
        boolean stop = false;
        Scanner sc = new Scanner(System.in);
        Plane plane = new Plane();
        System.out.println("(1) Show number of empty seats\n" +
                "(2) Show the list of empty seats\n" +
                "(3) Show the list of seat assignments by seat ID\n" +
                "(4) Show the list of seat assignments by customer ID\n" +
                "(5) Assign a customer to a seat\n" +
                "(6) Remove a seat assignment\n" +
                "(7) Exit");
        while (!stop){
            System.out.println("Enter the number of your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    plane.showNumEmptySeats();
                    break;
                case 2:
                    plane.showEmptySeat();
                    break;
                case 3:
                    plane.showAssignedSeat();
                    break;
                case 4:
                    PlaneSeat[] seat = plane.sortSeats();
                    for (int i = 0; i < seat.length; i++){
                        if (seat[i].isOccupied())
                            System.out.println("SeatID " +  seat[i].getSeatID() + " assigned to CustomerID " +  seat[i].getCustomerId());
                    }
                    break;
                case 5:
                    System.out.println("Assigning Seat ..");
                    System.out.println("Please enter SeatID: ");
                    seatId = sc.nextInt();
                    System.out.println("Please enter Customer ID: ");
                    CustomerID = sc.nextInt();
                    plane.assignSeat(seatId,CustomerID);
                    break;
                case 6:
                    System.out.println("Enter SeatID to unassigned customer from: ");
                    seatId = sc.nextInt();
                    plane.unAssignSeat(seatId);
                    System.out.println("Seat Unassigned!");
                    break;
                default:
                    stop = true;
                    break;
            }
        }
    }
}
