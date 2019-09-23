package NTULabs;
import java.lang.String;
public class SalePerson implements Comparable<SalePerson>{
    private int totalSales;
    private String lastName, firstName;
    public SalePerson(String firstName,String lastName, int totalSales){
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSales = totalSales;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTotalSales() {
        return totalSales;
    }

    @Override
    public java.lang.String toString() {
        return this.lastName + "," + this.firstName + ":" + totalSales ;
    }

    @Override
    public boolean equals(Object obj) {
        SalePerson p1 = (SalePerson)obj;
        return (this.getFirstName() == p1.getFirstName()) &&
                (this.getLastName() == p1.getLastName());
    }

    @Override
    public int compareTo(SalePerson o) {
        return this.getTotalSales() - o.getTotalSales();
    }
}
