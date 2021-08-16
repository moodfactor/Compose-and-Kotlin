package com.mood;

import static com.mood.Example.exch;
import static com.mood.Example.less;

public class Selection
{
    public static void sort(Comparable[] a)
    { // Sort a[] into increasing order.
        int N = a.length;
        // array length
        for (int i = 0; i < N; i++)
        { // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i;
            // index of minimal entr.
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }
// See page 245 for less(), exch(), isSorted(), and main().
}

