package Tutorial_3_CZ2002;

import java.util.Scanner;

public class VendingMachine {
    double amount;
    Scanner sc;
    public VendingMachine(){
        this.sc = new Scanner(System.in);
        this.amount = 0.0;
    }

    public double selectDrink(){
        double price = 0.0;
        int selection = this.sc.nextInt();
        switch(selection){
            case 1:
                price = 3.0;
                break;
            case 2:
                price = 1.0;
                break;
            case 3:
                price = 5.0;
                break;
        }
        return price;
    }

    public double insertCoins(double drinkCost){
        double inserted = 0;
        System.out.println(
                "Please insert coins:\n" +
                "========== Coins Input ===========\n" +
                "|Enter 'Q' for ten cents input |\n" +
                "|Enter 'T' for twenty cents input|\n"+
                "|Enter 'F' for fifty cents input |\n" +
                "|Enter 'N' for a dollar input |\n" +
                "==================================");
        try{
            while (this.amount < drinkCost){
                char coin = this.sc.next().charAt(0);
                switch (coin){
                    case 'Q':
                        inserted = 0.1;
                        break;
                    case 'T':
                        inserted = 0.2;
                        break;
                    case 'F':
                        inserted = 0.5;
                        break;
                    case 'N':
                        inserted = 1.0;
                        break;
                }
                this.amount += inserted;
                System.out.printf("Coins inserted: %.1f\n" , this.amount);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return this.amount;
        }

    }

    public void checkChange(double amount , double drinkCost){
        System.out.printf("Change: $ %.1f\n"  , (amount - drinkCost) );
    }

    public void printReceive(){
        System.out.println("Please collect your drink\n" +
                            "Thank You !!");
    }


}
