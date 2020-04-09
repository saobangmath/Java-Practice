package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class isSolvable {
    public static void main(String[] args) {
        String[] words = {"FIA","EDEBC"};
        String result = "FCJIFJ";
        System.out.println(issSolvable(words, result));
    }
    public static long f(HashMap<Character, Integer> hm, HashMap<Character, Integer> map){
        long r = 0;
        for (Character ch : hm.keySet()){
            r += hm.get(ch) * map.get(ch);
        }
        return r;
    }
    public static boolean issSolvable(String[] words, String result) {
        int l = words.length;
        boolean mark[] = new boolean[10];
        HashMap<Character, Integer> hm = new HashMap<>(); // mapping character to its
        HashMap<Character, Integer> map = new HashMap<>(); // mapping character to digit
        HashMap<Character, Integer> _res = new HashMap<>();

        ArrayList<Character> keys = new ArrayList<>();
        for (int i = 0; i < l; i++){
            int length = words[i].length();
            for (int j = 0; j < length; j++){
                char ch = words[i].charAt(j);
                int old = hm.getOrDefault(ch, 0);
                int update = old + (int)Math.pow(10, length - j - 1);
                hm.put(ch, update);
                if (!keys.contains(ch)){
                    keys.add(ch);
                }
            }
        }
        for (int i = 0; i < result.length(); i++){
            char ch = result.charAt(i);
            int old = _res.getOrDefault(ch, 0);
            int update = old + (int)Math.pow(10, result.length() - i - 1);
            _res.put(ch, update);
            if (!keys.contains(ch)){
                keys.add(ch);
            }
        }
        for (Character ch : keys){
            int out = _res.getOrDefault(ch, 0);
            int in = hm.getOrDefault(ch, 0);

            _res.put(ch, out - in);
            hm.remove(ch);
        }
        boolean res = dfs(words, _res, hm, map, mark, keys, 0);
        return res;
    }
    private static boolean dfs(String[] words, HashMap<Character, Integer> _res, HashMap<Character, Integer> hm, HashMap<Character, Integer> map,
                               boolean[] mark, ArrayList<Character> keys, int in){
        int l = keys.size();
        if (in == l){

            return (f(_res, map) == f(hm,  map));
        }
        else{
            for (int digit = 0; digit <= 9; digit++){
                if (!mark[digit]){
                    mark[digit] = true;
                    map.put(keys.get(in), digit);
                    boolean au = dfs(words, _res, hm, map, mark, keys, in + 1);
                    mark[digit] = false;
                    if (au) return true;
                }
            }
        }
        return false;
    }
}
