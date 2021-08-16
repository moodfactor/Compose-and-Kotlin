package com.mood;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

import static edu.princeton.cs.algs4.ThreeSum.count;

public class Main {

    public static void main(String[] args) {

//        int N = Integer.parseInt(In.readStrings("src/com/mood/100ints.txt")[0]);
//        int[] a = new int[N];
//        for (int i = 0; i < N; i++)
//            a[i] = StdRandom.uniform(-100, 100);
//        Stopwatch timer = new Stopwatch();
//        int cnt = ThreeSum.count(a);
//        double time = timer.elapsedTime();
//        StdOut.println(cnt + " triples " + time);

//        int[] a = In.readInts("src/com/mood/8Kints.txt");
//        StdOut.println(count2Sum(a));

        Alphabet alpha = new Alphabet(args[0]);
        int R = alpha.radix();
        int[] count = new int[R];
        String s = StdIn.readAll();
        int N = s.length();
        for (int i = 0; i < N; i++)
            if (alpha.contains(s.charAt(i)))
                count[alpha.toIndex(s.charAt(i))]++;
        for (int c = 0; c < R; c++)
            StdOut.println(alpha.toChar(c)
                    + " " + count[c]);

    }

    public static int count2Sum(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;

        for (int i =0; i<N; i++){
            if (BinarySearch.indexOf(a, -a[i]) > i){
                cnt++;
            }
        }
        return cnt;
    }
}
