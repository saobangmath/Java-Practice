package Interview;

import java.util.*;

public class DataStructure {
    public static void main(String[] args) {
        LinkedList();
        Vector();
        HashSet();
        TreeSet();
        TreeMap();
    }

    private static void TreeMap() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1,1);
        treeMap.put(1,2);
        //testing
        assert (treeMap.containsValue(2));
        assert(!treeMap.containsKey(2));
        assert (!treeMap.containsValue(3));
    }

    private static void TreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 10; i++){
            treeSet.add(i);
        }
        System.out.println(treeSet);
    }

    private static void HashSet() {
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int i = 0; i < 10; i++){
            hashSet1.add(i);
            hashSet2.add(i);
        }
        hashSet1.add(0);
        System.out.println(hashSet1);
        System.out.println(hashSet2);
        //assert(hashSet1 == hashSet2);
    }

    private static void Vector() {
        Vector v1 = new Vector();
        Vector v2 = new Vector();
        v2.add(0);
        for (int i = 0; i < 10; i++){
            v1.add(0, i);
            v2.add(0, i + 1);
        }
        // testing
        assert(v2.containsAll(v1));
        v1.clear();
        assert(v1.isEmpty());
    }

    public static void LinkedList(){
        LinkedList<Integer>  linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++){
            linkedList.addFirst(i);
        }
        // testing
        assert(!linkedList.contains("4343"));
        assert (linkedList.contains(9));
    }
}
