package Tutorial_6_CZ2002;

public class Bank {
    private CheckingAccount acc;
    private Check check;
    public Bank(){
        this.acc = new CheckingAccount();
        this.check = new Check(10, 1);
    }
    public double cashCheck(Check theCheck){
        double amount = theCheck.getAmount();
        double balance = this.acc.getBalance();
        if (balance < amount){
            this.acc.addInsufficientFundFee();
            this.acc.noteReturnedCheck(theCheck);
            this.returnCheck(theCheck);
            return -1;
        }
        else{
            int checkNumber = this.check.getCheckNo();
            this.acc.addDebitTransaction(this.check.getCheckNo(), this.check.getAmount());
            this.acc.storePhotoOfCheck(this.check);
            return amount;
        }
    }
    public void returnCheck(Check theCheck){

    }
}
