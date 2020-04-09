package Greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ScheduleCourse {
    public class Course implements Comparable<Course>{
        private int threshold, duration;
        public Course(int duration, int threshold){
            this.duration = duration;
            this.threshold = threshold;
        }

        public int getDuration() {
            return duration;
        }

        public int getThreshold() {
            return threshold;
        }
        @Override
        public int compareTo(Course o) {
            if (o.threshold < this.threshold){
                return 1;
            }
            else if (o.threshold > this.threshold){
                return -1;
            }
            else{
                if (o.duration < this.duration){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        }
    }
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        int i, r = 0, cur = 0;
        Course[] x = new Course[n];
        for (i = 0; i < n; i++){
            x[i] = new Course(courses[i][0], courses[i][1]);
        }
        Arrays.sort(x);
        i = 0;
        while (i < n){
            Course course = x[i];
            int duration = course.getDuration();
            int threshold = course.getThreshold();
            if (cur + duration <= threshold){
                cur = cur + duration;
                r++;
            }
            i++;
        }
        return r;
    }

    public static void main(String[] args) {

    }
}
