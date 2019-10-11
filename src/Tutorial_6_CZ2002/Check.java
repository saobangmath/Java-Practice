package Tutorial_6_CZ2002;

public class Check {
    private double checkAmount;
    private int checkNo;
    public Check(double checkAmount, int checkNo){
        this.checkAmount = checkAmount;
        this.checkNo = checkNo;
    }

    public double getAmount() {
        return this.checkAmount;
    }

    public int getCheckNo() {
        return this.checkNo;
    }
}
