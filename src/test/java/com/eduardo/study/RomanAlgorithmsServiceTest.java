package com.eduardo.study;

import com.eduardo.study.service.RomanAlgorithmsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RomanAlgorithmsServiceTest {

    @Autowired
    private RomanAlgorithmsService romanAlgarismsService;

    @Test
    void validateWith_VIII() throws Exception {
        Integer actual = romanAlgarismsService.transformRomanAlgarismToHinduArabic("VIII");
        assertEquals(8, actual);
    }

    @Test
    void validateWith_XL() throws Exception {
        Integer actual = romanAlgarismsService.transformRomanAlgarismToHinduArabic("XL");
        assertEquals(40, actual);
    }

    @Test
    void validateWith_XC() throws Exception {
        Integer actual = romanAlgarismsService.transformRomanAlgarismToHinduArabic("XC");
        assertEquals(90, actual);
    }

    @Test
    void validateWith_CCC() throws Exception {
        Integer actual = romanAlgarismsService.transformRomanAlgarismToHinduArabic("CCC");
        assertEquals(300, actual);
    }

    @Test
    void validateWith_CD() throws Exception {
        Integer actual = romanAlgarismsService.transformRomanAlgarismToHinduArabic("CD");
        assertEquals(400, actual);
    }

    @Test
    void validateWith_DCCC() throws Exception {
        Integer actual = romanAlgarismsService.transformRomanAlgarismToHinduArabic("DCCC");
        assertEquals(800, actual);
    }

    @Test
    void validateWith_CM() throws Exception {
        Integer actual = romanAlgarismsService.transformRomanAlgarismToHinduArabic("CM");
        assertEquals(900, actual);
    }

    @Test()
    void validateWith_invalidLetters() {
        Assertions.assertThrows(Exception.class, () -> {
            romanAlgarismsService.transformRomanAlgarismToHinduArabic("ABC");
        });
    }
}
