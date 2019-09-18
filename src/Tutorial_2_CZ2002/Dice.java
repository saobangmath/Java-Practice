package Tutorial_2_CZ2002;

public class Dice {
    private int valueOfDice;

    public Dice(int valueOfDice){
        this.valueOfDice  = valueOfDice;
    }

    public void setDiceValue(int valueOfDice){
        this.valueOfDice = valueOfDice;
    }

    public int getDiceValue(){
        return this.valueOfDice;
    }

    public void printDiceValue(){
        System.out.println("Current Value is: " + this.getDiceValue());
    }
}
