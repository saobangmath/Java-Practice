import java.util.*;

public class ValidWord {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int val = 0;
        List<Boolean> ans = new ArrayList<Boolean>();
        Map<Character,Integer> m = new HashMap<>();
        int[][] count = new int[s.length()+1][26];
        Arrays.fill(count[0],0);

        for (char ch = 'a'; ch <= 'z';ch++){
            m.put(ch,val++);
        }
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < 26;j++){
                if (j == m.get(s.charAt(i-1)))
                    count[i][j] = count[i-1][j] +1;
                else
                    count[i][j] = count[i-1][j];
            }
        }
        for (int i = 0; i < queries.length; i ++){
            int r = 0;
            for (int j = 0; j < 26; j++ ) {
                r += (count[queries[i][1] + 1][j] - count[queries[i][0]][j]) % 2;
            }
            ans.add((r / 2 <= queries[i][2]));
        }
        return ans;
    }
    public static void main(ReverseString[] args) {

    }
}
