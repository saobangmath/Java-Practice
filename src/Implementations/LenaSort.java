package Implementations;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LenaSort {


    static long[] mmax = new long[100001];
    static long[] mmin = new long[100001];

    private static final InputReader in = new InputReader(System.in);
    private static final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int q = in.nextInt();

        int i;
        for(i = 2; i <= 100000; i++){
            mmax[i] = (long)(i - 1) * i / 2;
            mmin[i] = mmin[i / 2] + mmin[i - i / 2 - 1] + (i - 1);
        }

        for (int qItr = 0; qItr < q; qItr++) {
            int l = in.nextInt();

            int c = in.nextInt();

            if (c > mmax[l] || mmin[l] > c){
                pw.print(-1);
            }
            else{
                solve( 1, l, c);
            }
            pw.println();
        }
        pw.close();
    }

    private static void solve(int start, int end, long c) {
        if (end < 3){
            for (int i = start; i <= end; i++){
                pw.print(i + " ");
            }
        }
        else{
            c -= (end - start);
            for (int divide = start; divide <= end; divide++){
                long s = mmin[divide - start] + mmin[end - divide];
                long e = mmax[divide - start] + mmax[end - divide];
                if (c >= s && e >= c){
                    pw.print(divide + " ");
                    long choosen = Math.max(mmin[divide - start], c - mmax[end -  divide]);
                    solve(start, divide - 1, choosen);
                    solve(divide + 1, end, c - choosen);
                    return;
                }
            }
        }
    }
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        public long nextLong(){
            return Long.parseLong(nextToken());
        }
    }
}
