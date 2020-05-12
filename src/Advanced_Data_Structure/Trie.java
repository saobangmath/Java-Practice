package Advanced_Data_Structure;

/**
 * @author: Tran Anh Tai
 * Trie class with testing and basic operation for the trie data structure;
 */
public class Trie {
    static int ALPHABETIC_SIZE = 26;
    Trie[] children = new Trie[26];
    boolean isEndofWord;
    // constructor;
    public Trie(){
        this.isEndofWord = false;
        for (int i = 0; i < ALPHABETIC_SIZE; i++){
            children[i] = null;
        }
    }
    // insert a new string to the trie;
    void insert(String key){
        int l = key.length();
        Trie current = this;
        for (int i = 0; i < l; i++){
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null){
                current.children[index] = new Trie();
            }
            current = current.children[index];
        }
        current.isEndofWord = true;
    }
    //search whether a string emerge in the trie;
    boolean search(String key){
        int l = key.length();
        Trie current = this;
        for (int i = 0; i < l; i++){
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return current.isEndofWord;
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }
    static class Test implements Runnable{
        @Override
        public void run() {
            String keys[] = {"the", "a", "there",
                    "answer", "any", "by",
                    "bye", "their", "tourist" };

            Trie root = new Trie();

            // Construct trie
            for (int i = 0; i < keys.length; i++)
                root.insert(keys[i]);

            // Search for different keys
            assert(root.search("the"));
            assert(root.search("tourist"));
            assert(!root.search("hjs"));
            assert(!root.search("aa"));
        }
    }
}
