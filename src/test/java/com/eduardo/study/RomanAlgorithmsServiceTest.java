package com.eduardo.study;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.eduardo.study.service.RomanAlgorithmsService;

public class RomanAlgorithmsServiceTest {

    @Test()
    void validateWith_invalidLetters() {
        Assertions.assertThrows(Exception.class, () -> {
            RomanAlgorithmsService.transformRomanAlgarismToHinduArabic("ABC");
        });
    }

    @ParameterizedTest
    @MethodSource()
    void validateNumbers(int expected, String actual) throws Exception {
        assertEquals(expected, RomanAlgorithmsService.transformRomanAlgarismToHinduArabic(actual));
    }

    private static Stream<Arguments> validateNumbers() {
        return Stream.of(
                Arguments.of(8, "VIII"),
                Arguments.of(40, "XL"),
                Arguments.of(90, "XC"),
                Arguments.of(300, "CCC"),
                Arguments.of(400, "CD"),
                Arguments.of(800, "DCCC"),
                Arguments.of(900, "CM"));
    }
}
