package com.eduardo.study;

import com.eduardo.study.service.FindMultiplesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FindMultiplesServiceTest {

    @Autowired
    private FindMultiplesService findMultiplesService;

    @Test
    void firstCombination() {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 7, 7));
        Set<Integer> expected = new HashSet<Integer>(Arrays.asList(1, 2, 3, 7));

        Set<Integer> actual = findMultiplesService.findMultiples(numbers);
        assertEquals(expected, actual);
    }

    @Test
    void secondCombination() {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        Set<Integer> expected = new HashSet<Integer>(Arrays.asList());

        Set<Integer> actual = findMultiplesService.findMultiples(numbers);
        assertEquals(expected, actual);
    }

    @Test
    void thirdCombination() {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3));
        Set<Integer> expected = new HashSet<Integer>(Arrays.asList(2));

        Set<Integer> actual = findMultiplesService.findMultiples(numbers);
        assertEquals(expected, actual);
    }

    @Test
    void forthCombination() {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 3, 2, 1, 5, 5));
        Set<Integer> expected = new HashSet<Integer>(Arrays.asList(3, 2, 5));

        Set<Integer> actual = findMultiplesService.findMultiples(numbers);
        assertEquals(expected, actual);
    }

    @Test
    void fifthCombination() {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(-1, 0, 1, 5, -1));
        Set<Integer> expected = new HashSet<Integer>(Arrays.asList(-1));

        Set<Integer> actual = findMultiplesService.findMultiples(numbers);
        assertEquals(expected, actual);
    }
}
