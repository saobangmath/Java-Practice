package Backtracking;

public class StickerToSpellWord {
    public static void main(String[] args) {
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";
    }
    public static int minStickers(String[] stickers, String target) {
        int[] t = new int[26];
        int l = target.length();
        for (int i = 0; i < l; i++){
            t[target.charAt(i) - 'a'] ++;
        }
        return 0;
    }
}
