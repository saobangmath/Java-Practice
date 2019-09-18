package Tutorial_4_CZ2002;

import java.util.Scanner;

public class CalculatorEx {
    double result;
    public CalculatorEx(){
        this.result = 0.0;
    }
    public double resultValue(){
        return this.result;
    }
    public void doCalculation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Calculator is on\n" +
                           "result = 0.0");
        char op = sc.next().charAt(0);

        while (op != 'Q' && op != 'q'){
            double num = sc.nextDouble();
            try{
                this.evaluate(op,this.result,num);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Please reenter:");
                System.out.println("update result = " + this.handleUnknownOpException());
            }
            finally {
                op = sc.next().charAt(0);
            }
        }
        System.out.println("Final result = " + this.result);
        System.out.println("End of Program");
        sc.close();
    }
    public void evaluate(char op, double n1, double n2) throws Exception{
        switch (op){
            case '+': this.result = n1 + n2;break;
            case '-': this.result = n1 - n2;break;
            case '*': this.result = n1 * n2;break;
            case '/': this.result = n1 / n2;break;
            default : throw new UnknownOperatorException(op);
        }
        n1 = this.result;
        System.out.println("result " + op +" " + n2 + " = " + n1);
        System.out.println("updated result = "+ n1);
    }
    public double handleUnknownOpException(){

        return this.result;
    }
    public static void main(String[] args) {
        CalculatorEx calculatorEx = new CalculatorEx();
        calculatorEx.doCalculation();
    }
}
