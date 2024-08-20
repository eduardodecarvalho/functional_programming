package com.eduardo.study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KidsAndCandies {

    @Test
    void kidsWithMoreCandies() {
        List<Integer> candies = Arrays.asList(2, 3, 5, 1, 3);
        int myCandies = candies.getLast();
        int greaterValue = Collections.max(candies);

        List<Boolean> result = candies.stream().map(
                        candy -> candy + myCandies >= greaterValue)
                .toList();

        System.out.println(result);
    }
}
