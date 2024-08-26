package com.eduardo.study;

import com.eduardo.study.service.FindMultiplesService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FindMultiplesServiceTest {

    @Autowired
    private FindMultiplesService findMultiplesService;

    public static Stream<Arguments> findMultiples() {
        return Stream.of(Arguments.of(
                        new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 7, 7)), new HashSet<>(Arrays.asList(1, 2, 3, 7)),
                        new ArrayList<>(Arrays.asList(1, 2, 3)), new HashSet<Integer>(List.of()),
                        new ArrayList<>(Arrays.asList(1, 2, 2, 3)), new HashSet<>(List.of(2)),
                        new ArrayList<>(Arrays.asList(2, 3, 4, 5, 3, 2, 1, 5, 5)), new HashSet<>(Arrays.asList(3, 2, 5)),
                        new ArrayList<>(Arrays.asList(-1, 0, 1, 5, -1)), new HashSet<>(List.of(-1))
                )
        );
    }

    @ParameterizedTest
    @MethodSource
    void findMultiples(List<Integer> numbers, HashSet<Integer> expected) {
        Set<Integer> actual = findMultiplesService.findMultiples(numbers);
        assertEquals(expected, actual);
    }

}
