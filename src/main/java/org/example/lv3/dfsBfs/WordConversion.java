package org.example.lv3.dfsBfs;

import java.util.*;

public class WordConversion {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"})); // 4
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));        // 0
    }

    public static int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target))
            return 0;

        Set<String> wordSet = new HashSet<>();
        Collections.addAll(wordSet, words);

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(begin, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.word;
            int step = curr.step;

            if (word.equals(target)) {
                System.out.println("step = " + step);
                return step;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] wordChars = word.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {

                    wordChars[i] = c;
                    String newWord = new String(wordChars);
                    if (wordSet.contains(newWord) && !newWord.equals(word)) {
                        q.offer(new Pair(newWord, step + 1));
                        wordSet.remove(newWord);
                    }
                    wordChars[i] = word.charAt(i);
                }
            }
        }

        return 0;
    }

    static class Pair {
        String word;
        int step;

        public Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}
