package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Tran Anh Tai
 * for Leetcode problem: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 * This one is just optimized the number of events attended for the timestamps as predefined.
 * The ideas is sorted those events in the increasing order of (starting time, ending time);
 * The always prioritize the event with lowest starting time and ending time for choosing as an attended event.
 * That's because if we choosing another event instead of this event, we could replace such event with such another event that the number of events not changed
 * Moreover, the chance to have more events attended is increased!
 */
public class MaxEvents {
    public static void main(String[] args) {
        int[][] events = new int[][]{{1,2},{1,1},{1,3}};
        System.out.println(maxEvents(events));
    }
    public static int maxEvents(int[][] events) {
        PriorityQueue<Event> pq = new PriorityQueue<>(new CustomCriteria());
        int cnt = 0;
        int time;
        for (int[] e : events){
            Event event = new Event(e[0], e[1]);
            pq.add(event);
        }

        while (!pq.isEmpty()){
            cnt++;
            Event top = pq.poll();
            time = top.start;
            while (!pq.isEmpty()){
                Event e = pq.poll();
                if (e.start == time){
                    if (e.end > time){
                        pq.add(new Event(e.start + 1, e.end));
                    }
                }
                else{
                    pq.add(e);
                    break;
                }
            }
        }
        return cnt;
    }
    static class CustomCriteria implements Comparator<Event> {

        @Override
        public int compare(Event o1, Event o2) {
            if (o1.start < o2.start){
                return -1;
            }
            else if (o1.start > o2.start){
                return 1;
            }
            else{
                if (o1.end < o2.end){
                    return -1;
                }
                else if (o1.end > o2.end){
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
    }
    public static class Event{
        public int start, end;
        public Event(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
