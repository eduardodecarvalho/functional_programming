package com.eduardo.study.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FindMultiplesService {

    public Set<Integer> findMultiples(List<Integer> numbers) {
        Set<Integer> list = new HashSet<>();
        Set<Integer> auxSet = new HashSet<>();

        for (int aux : numbers) {
            if (!auxSet.add(aux)) {
                list.add(aux);
            }
        }
        return list;
    }
}
