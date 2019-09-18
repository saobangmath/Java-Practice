package Tutorial_3_CZ2002;


public class VendingMachineApp {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        System.out.print("====== Vending Machine ======\n" +
                "|1. Buy Beer ($3.00) |\n" +
                "|2. Buy Coke ($1.00) |\n" +
                "|3. Buy Green Tea ($5.00) |\n" +
                "|============================\n" +
                "Please enter selection:" );

        double drinkCost = vendingMachine.selectDrink();
        double amount = vendingMachine.insertCoins(drinkCost);
        vendingMachine.checkChange(amount, drinkCost);
        vendingMachine.printReceive();
        vendingMachine.sc.close();
    }
}
