package Tutorial_4_CZ2002;

public class UnknownOperatorException extends Exception {
    public UnknownOperatorException(){
        super();
    }
    public UnknownOperatorException(char op){
        super(op + " is an unknown operator");
    }
    public UnknownOperatorException(String message){
        super(message);
    }
}
