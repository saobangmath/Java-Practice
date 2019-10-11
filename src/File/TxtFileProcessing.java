package File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileProcessing {
    public static void main(String[] args){
        try{
            // create and opnen fuke streams
            FileReader iStream = new FileReader("input.txt");
            FileWriter oStream = new FileWriter("output.txt");
            //perform read and write operation
            int data;
            data = iStream.read();
            oStream.write(data);
            //close FileStream
            iStream.close();
            oStream.close();
        }
        catch (IOException e){
            System.out.println("IO Error !" + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }
}
