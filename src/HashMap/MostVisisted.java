package HashMap;

import java.util.*;

public class MostVisisted {
    Map<Integer, String> map = new HashMap<>();
    Map<String, Integer> count = new HashMap<>();
    String key = "";
    int maxinum;
    public MostVisisted(String[] lines, int k){
        this.maxinum = 0;
        this.key = "";
        ArrayList<Integer> l = new ArrayList<>();
        for (String line : lines){
            int id = line.charAt(0) - '0';
            String val = this.map.getOrDefault(id,"");
            if (val.equals("")) {
                this.map.put(id, line.charAt(2) + "");
            }
            else{
                String au;
                if(val.length() < k){
                    au = val + line.charAt(2);
                }
                else{
                    au = val.substring(1) + line.charAt(2);
                }
                if (au.length() == k){
                    int t = this.count.getOrDefault(au,0 ) + 1;
                    if (t > this.maxinum){
                        this.maxinum = t;
                        this.key = au;
                    }
                    this.count.put(au, t);

                }
                this.map.put(id, au);
            }
        }
    }
    public static void main(String[] args) {
        String[] lines = {"1 B", "2 A", "5 E", "4 B", "4 A", "2 C", "5 C", "3 B", "4 C", "2 C"};
        int k = 2;
        MostVisisted sol = new MostVisisted(lines, k);
        String result = sol.findKMostVisitedPagePattern();
        assert (result.equals("AC 2"));
    }
    public String findKMostVisitedPagePattern() {
        return this.key + " " + this.maxinum;
    }
}
