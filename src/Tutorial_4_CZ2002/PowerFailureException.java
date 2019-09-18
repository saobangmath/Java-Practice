package Tutorial_4_CZ2002;

public class PowerFailureException extends Exception{
    public PowerFailureException(){
        super("Power Failure");
    }
    public PowerFailureException(String s){
        super(s);
    }

    public static void main(String[] args){
        PowerFailureException t  =new PowerFailureException();
        System.out.println(t.getMessage());
    }
}
