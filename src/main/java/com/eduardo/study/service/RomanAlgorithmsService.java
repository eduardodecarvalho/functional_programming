package com.eduardo.study.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;

@Service
public class RomanAlgorithmsService {

    /**
     * Transform any roman algarisms in hindu arabic numerals.
     */

    private static final HashMap<String, Integer> algarisms = new HashMap<>();

    static {
        algarisms.put("I", 1);
        algarisms.put("V", 5);
        algarisms.put("X", 10);
        algarisms.put("L", 50);
        algarisms.put("C", 100);
        algarisms.put("D", 500);
        algarisms.put("M", 1000);
    }

    public Integer transformRomanAlgarismToHinduArabic(String romanAlgarismNumber) throws Exception {
        Integer hinduArabicNumeral = 0;

        String toUpperCase = romanAlgarismNumber.toUpperCase();

        validationLetters(toUpperCase);

        for (int i = 0; i < toUpperCase.length(); i++) {
            String actualLetter = String.valueOf(toUpperCase.charAt(i));
            String nextLetter = i == toUpperCase.length() - 1 ? ""
                    : String.valueOf(toUpperCase.charAt(i + 1));
            if (StringUtils.hasLength(nextLetter) && shouldDecrease(actualLetter, nextLetter)) {
                hinduArabicNumeral -= algarisms.get(actualLetter);
            } else {
                hinduArabicNumeral += algarisms.get(actualLetter);
            }
        }
        return hinduArabicNumeral;
    }

    private void validationLetters(String romanAlgarismNumber) throws Exception {
        var invalidLetters = new StringBuilder();
        for (int i = 0; i < romanAlgarismNumber.length(); i++) {
            String actualLetter = String.valueOf(romanAlgarismNumber.charAt(i));
            if (algarisms.get(actualLetter) == null) {
                invalidLetters.append(actualLetter);
            }
        }
        if (!invalidLetters.isEmpty()) {
            throw new Exception("Invalid letters: " + invalidLetters);
        }
    }

    private boolean shouldDecrease(String actualLetter, String nextLetter) {
        return algarisms.get(actualLetter) < algarisms.get(nextLetter);
    }
}
