package Advanced_Data_Structure;
import Tutorial_3_CZ2002.Point;

import java.util.*;
public class Skylines{
    public static void main(String[] args) {
        int[][] buildings = new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<List<Integer>> result = getSkyline(buildings);
        for (List<Integer> l : result){
            for (int i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        int l = buildings.length;
        Point[] checkpoints = new Point[2 * l];
        boolean visited[] = new boolean[l];
        PriorityQueue<Integer> heights = new PriorityQueue<>(new CustomComparator());
        int i, start, height;
        Point s;
        for (i = 0; i < 2 * l; i += 2){
            checkpoints[i] = new Point(i / 2, buildings[i / 2][0], buildings[i / 2][2]);
            checkpoints[i + 1] = new Point(i / 2, buildings[i / 2][1], buildings[i / 2][2]);
        }
        Arrays.sort(checkpoints);

        visited[0] = true;
        start = buildings[0][0];
        height = buildings[0][2];
        heights.offer(buildings[0][2]); // the heights of the first checkpoint;

        i = 1;
        while(i < 2 * l){
            Point p = checkpoints[i];
            while (i < 2 * l && p.x == checkpoints[i].x){
                i++;
            }
            if (p.h > height){
                result.add(CreatedPair(start, height));
                height = p.h;
                start = p.x;
            }
            if (visited[p.index]){
                heights.remove(p.h); // remove the height as it is no longer in the priority queue;
                if (heights.isEmpty()){
                    result.add(CreatedPair(start, height));
                    start = p.x;
                    height = 0;
                    continue;
                }
                int new_height = heights.peek();
                if (new_height < height){
                    result.add(CreatedPair(start, height));
                    start = p.x;
                }
                height = new_height;
            }
            else{
                visited[p.index] = true;
                heights.offer(p.h);
            }
        }
        result.add(CreatedPair(start, 0));
        return result;
    }
    private static class CustomComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2){
                return -1;
            }
            else if (o1 < o2){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
    private static List<Integer> CreatedPair(int start, int height) {
        List<Integer> created =  new ArrayList<>();
        created.add(start);
        created.add(height);
        return created;
    }

    static class Point implements Comparable<Point>{
        public int index, x, h;
        public Point(int index, int x, int h){
            this.index = index;
            this.x = x;
            this.h = h;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x > o.x) {
                return 1;
            }
            else if (this.x < o.x){
                return -1;
            }
            else{
                if (this.h > o.h){
                    return -1;
                }
                else if (this.h < o.h){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }
    }
}
