package org.example.lv3.hash;

import java.util.Arrays;

public class PhoneBook {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        String word = "hit";

        // sorting
        Arrays.sort(phone_book);

        // loop & check
        for (int i = 0; i < phone_book.length - 1; i++) {
            String curr_phone = phone_book[i];
            String next_phone = phone_book[i + 1];

            if (next_phone.startsWith(curr_phone)) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
