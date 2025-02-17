package com.my.codingtest.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 영어_끝말잇기 {

    public static void main(String[] args) {
        int n1 = 3;
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        // {3, 3}

        int n2 = 5;
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        // {0, 0}

        int n3 = 2;
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        // {1, 3}

        System.out.println(Arrays.toString(solution(n3, words3)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {};

        answer = new int[2];
        Map<String, Integer> hashMap = new HashMap<>();
        String beforeWord = String.valueOf(words[0].charAt(0));

        for(int i=0;i<words.length;i++) {
            String word = words[i];
            int person = i % n + 1;

            if(beforeWord.charAt(beforeWord.length()-1) == word.charAt(0)) {
                if(!hashMap.containsKey(word)) {
                    hashMap.put(word, person);
                    beforeWord = word;
                } else {
                    answer[0] = person;
                    answer[1] = i / n + 1;
                    break;
                }
            } else {
                answer[0] = person;
                answer[1] = i / n + 1;
                break;
            }
        }

        return answer;
    }

}
