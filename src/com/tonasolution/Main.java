package com.tonasolution;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] intArray = { 54, 46, 83, 66, 95, 92, 43 };

        bucketSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void bucketSort(int[] input) {

        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++ ) {
            // == using the linkedList for the bucket ==
            // buckets[i] = new LinkedList<Integer>();

            // == using ArrayList for the bucket ==
            buckets[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < input.length; i++ ) {
            buckets[hash(input[i])].add(input[i]);
        }

        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            Iterator<Integer> iterator = buckets[i].listIterator();

            // == First solution ==
            while (iterator.hasNext()) {
                input[j++] = iterator.next();
            }
            // == Second solution ==
//            for (int value : buckets[i]) {
//                input[j++] = value;
//            }
        }
    }

    private static int hash(int value) {
        return value / 10;
    }
}
