package com.eduardo.study;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GroupAnagrams {

    List<String> groupAnagrams = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");

    @Test
    void testAnagrams() {
        if (groupAnagrams.size() == 0) {
            System.out.println("invalid array");
        }
        Map<String, List> ans = new HashMap<>();
        for (String s : groupAnagrams) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!ans.containsKey(sorted)) {
                ans.put(sorted, new ArrayList<>());
            }
            ans.get(sorted).add(s);
        }
        System.out.println(ans.values());
    }

    @Test
    void testAnagrams2() {
        Map<String, List> result = new HashMap<>();
        for (String actual : groupAnagrams) {
            char[] chars = actual.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
        }
    }
}
