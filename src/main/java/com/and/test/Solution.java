package com.and.test;

import java.util.*;

public class Solution {

    /**
     * The following is the method where the solution shall be written
     */

    public static String solution(String input) throws NumberFormatException {
        String intValue = input.replaceAll("[^0-9]", "");

        if (intValue.isEmpty()) {
            throw new NumberFormatException("Please enter a numeric value");

        }

        int[] digitArray = new int[intValue.length()];
        List<String> ls = new ArrayList<>();
        Set<List<Integer>> setOfPermutations = new HashSet<>();
        setOfPermutations.add(new ArrayList<>());

        for (int i = 0; i < intValue.length(); i++) {
            digitArray[i] = intValue.charAt(i) - '0';
        }

        for (int i = 0; i < digitArray.length; i++) {
            List<List<Integer>> current = new ArrayList<>();
            for (List<Integer> permutation : setOfPermutations) {

                int lenght = permutation.size();
                for (int j = 0; j < lenght + 1; j++) {

                    ArrayList<Integer> clonePermutation = (ArrayList<Integer>) ((ArrayList<Integer>) permutation).clone();
                    clonePermutation.add(j, digitArray[i]);
                    current.add(new ArrayList<>(clonePermutation));
                }
            }

            setOfPermutations = new HashSet<>(current);
        }

        for (List<Integer> permutation : setOfPermutations) {
            List<Integer> lsi = new ArrayList<>(permutation);
            StringBuilder sb = new StringBuilder();
            for (Integer i : lsi) {
                sb.append(i);
            }

            ls.add(sb.toString());
            Collections.sort(ls);
            Collections.reverse(ls);
        }

        String joinedString = String.join(",", ls);
        System.out.println(joinedString);
        return null;
    }

    public static void main(String[] args) {
        solution("236nnn");
    }
}