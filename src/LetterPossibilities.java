import java.util.HashMap;
import java.util.Map;

public class LetterPossibilities {
    public static int numTilePossibilities(String tiles){
        if (tiles.length() == 1){
            return 1;
        }
        else{
            int res = 0;
            int len = tiles.length();
            Map<Character,Boolean> map = new HashMap<>();
            for (int i = 0 ; i < len;  i++){
                char ch = tiles.charAt(i);
                if (!map.containsKey(ch)){
                    res ++;
                    map.put(ch,true);
                    res += numTilePossibilities(
                            tiles.substring(0,i) + tiles.substring(i+1,len));

                }
            }
            return res;
        }
    }
    public static void main(ReverseString[] args) {
        String tiles = "AAABBC";
        System.out.println(numTilePossibilities(tiles));
    }
}
