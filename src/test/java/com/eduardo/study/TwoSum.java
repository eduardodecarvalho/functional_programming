package com.eduardo.study;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class TwoSum {

    private final int target = 9;
    private final List<Integer> values = List.of(11, 15, 2, 7);

    @Test
    void twoSumTestBrutForce() {
        var hash = new HashMap<Integer, Integer>();
        int i = 0;
        for (Integer value : values) {
            int sum = target - value;
            if (values.contains(sum)) {
                System.out.println(i);
            }
            i++;
        }
        System.out.println(hash);
    }

    @Test
    void twoSumTestWithHasMap() {
        var hashMap = new HashMap<Integer, Integer>();
        int i = 0;
        for (Integer value : values) {
            int complement = target - value;
            if (null != hashMap.get(value)) {
                System.out.println("Index: " + i + " And: " + hashMap.get(value));
            }
            hashMap.put(complement, i);
            i++;
        }
    }

}
