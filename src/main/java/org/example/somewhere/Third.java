package org.example.somewhere;

import java.util.*;

public class Third {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(
                solution(new String[]{"ABACDEFG", "NOPQRSTU", "HIJKLKMM"}, new String[]{"GPQM", "GPMZ", "EFU", "MMNA"})));
        System.out.println(Arrays.toString(solution(new String[]{"AABBCCDD", "KKKKJJJJ", "MOMOMOMO"}, new String[]{"AAAKKKKKMMMMM", "ABCDKJ"})));
    }

    public static String[] solution(String[] card, String[] word) {
        List<String> validWords = new ArrayList<>();

        for (String w : word) {
            if (canFormWord(w, card)) {
                validWords.add(w);
            }
        }

        if (validWords.isEmpty()) {
            return new String[]{"-1"};
        }

        return validWords.toArray(new String[0]);
    }

    private static boolean canFormWord(String word, String[] card) {
        int[] usedLines = new int[3]; // To track whether we've used each line
        Map<Character, Integer>[] countMaps = new Map[3];

        // Initialize count maps for each card row
        for (int i = 0; i < 3; i++) {
            countMaps[i] = new HashMap<>();
            for (char c : card[i].toCharArray()) {
                countMaps[i].put(c, countMaps[i].getOrDefault(c, 0) + 1);
            }
        }

        // Check for each character in the word
        for (char c : word.toCharArray()) {
            boolean found = false;
            for (int i = 0; i < 3; i++) {
                if (countMaps[i].getOrDefault(c, 0) > 0) {
                    countMaps[i].put(c, countMaps[i].get(c) - 1);
                    usedLines[i] = 1; // Mark this line as used for this character
                    found = true;
                    break; // Only decrement from one line
                }
            }
            if (!found) return false; // If any letter cannot be found enough times, fail
        }

        // Check if all three lines were used
        return Arrays.stream(usedLines).sum() == 3;
    }
}
