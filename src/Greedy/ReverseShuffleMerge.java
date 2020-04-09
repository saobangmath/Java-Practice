package Greedy;

import java.util.HashMap;
import java.util.Map;

public class ReverseShuffleMerge {
    public static void main(String[] args) {
        String s = "bdabaceadaedaaaeaecdeadababdbeaeeacacaba";
        System.out.println(reverseShuffleMerge(s));
    }
    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        Map<Character, Integer> skipped =  new HashMap<>();
        Map<Character, Integer> used = new HashMap<>();

        int l = s.length();
        int index, i;
        char min, ch;
        String r = "";
        for (i = 0; i < l; i++){
            ch = s.charAt(i);
            try{
                int t = skipped.get(ch);
                skipped.put(ch, t + 1);
            }
            catch (Exception e){
                skipped.put(ch, 1);
            }
        }
        for (char key : skipped.keySet()){
            int t = skipped.get(key);
            skipped.put(key, t / 2);
            used.put(key, t / 2);
        }
        --i;
        while (i >= 0){
            ch = s.charAt(i);
            if (used.get(ch) == 0){
                skipped.put(ch, skipped.get(ch) - 1);
                i--;
            }
            else{
                min = ch;
                index = i;

                for (int j = i; j >= 0; j--){
                    char c1 = s.charAt(j);
                    int t = skipped.get(c1);
                    if (t == 0){ // no more skipped slots

                        r += min;
                        used.put(min, used.get(min) - 1);
                        // recover the skipped slot
                        for (int x = j + 1; x <= index; x++){
                            char c2 = s.charAt(x);
                            skipped.put(c2, skipped.get(c2) + 1);
                        }
                        break;
                    }
                    else{
                        skipped.put(c1, t - 1);
                        if (c1 < min && used.get(c1) > 0){
                            min = c1;
                            index = j;
                        }
                    }
                }
                i = index - 1;
            }
        }
        return r;
    }

}
