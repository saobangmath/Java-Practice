package NTULabs;
import java.util.Scanner;

public class String {
    public static void main(java.lang.String[] args) {
        java.lang.String[] StringList;
        int size;
        Scanner scan = new Scanner(System.in);
        System.out.print("\nHow many strings do you want to sort? ");
        size = scan.nextInt();
        StringList = new java.lang.String[size];
        System.out.println ("\nEnter the strings...");
        for (int i = 0; i < size; i++)
            StringList[i] = scan.next();
        //Sorting.selectionSort(StringList);
        Sorting.insertionSort(StringList);
        System.out.println ("\nYour string in sorted order...");
        for (int i = 0; i < size; i++)
            System.out.print(StringList[i] + " ");
        System.out.println();
    }
}
