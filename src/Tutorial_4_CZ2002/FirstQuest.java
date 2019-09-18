package Tutorial_4_CZ2002;

public class FirstQuest {
    public static void main(String[] args) {
        int waitTime = 12;
        try {
            System.out.println("Try block entered");
            if (waitTime > 30)
                throw new Exception("Time Limited Exceeded");
            System.out.println("Leaving try block");
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
        finally{
            System.out.println("After catch block");
        }
    }
}
