package Interview;

import java.rmi.server.ExportException;

public class TryCatch {
    public static void main(String[] args) {
        try{
            int x = 3/0;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Done!");
        }
    }
}
