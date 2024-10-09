package com.my.codingtest.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기_KAKAO {
    public static void main(String[] args) {
        String[] survey1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices1 = {5, 3, 2, 7, 5};

        String[] survey2 = {"TR", "RT", "TR"};
        int[] choices2 = {7, 1, 3};


        System.out.println(solution(survey2, choices2) + "");
    }

    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        answer.append("----");

        // 1번 지표	라이언형(R), 튜브형(T)
        // 2번 지표	콘형(C), 프로도형(F)
        // 3번 지표	제이지형(J), 무지형(M)
        // 4번 지표	어피치형(A), 네오형(N)
        // 단, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단
        /**
         * 1	매우 비동의 3
         * 2	비동의 2
         * 3	약간 비동의 1
         * 4	모르겠음 0
         * 5	약간 동의 1
         * 6	동의 2
         * 7	매우 동의 3
         * */
        Map<Integer, Integer> score = new HashMap<>();
        score.put(1, 3);
        score.put(2, 2);
        score.put(3, 1);
        score.put(4, 0);
        score.put(5, 1);
        score.put(6, 2);
        score.put(7, 3);

        Map<Character, Integer> position1 = new HashMap<>();
        position1.put('R', 1);
        position1.put('T', 1);
        position1.put('C', 2);
        position1.put('F', 2);
        position1.put('J', 3);
        position1.put('M', 3);
        position1.put('A', 4);
        position1.put('N', 4);

        Map<Integer, Character> position2 = new HashMap<>();
        position2.put(1, 'R');
        position2.put(2, 'C');
        position2.put(3, 'J');
        position2.put(4, 'A');

        Map<String, Integer> save = new HashMap<>();
        save.put("R", 0);
        save.put("T", 0);
        save.put("C", 0);
        save.put("F", 0);
        save.put("J", 0);
        save.put("M", 0);
        save.put("A", 0);
        save.put("N", 0);

        for(int i=0;i<survey.length;i++) {
            int select = choices[i];
            char a = survey[i].toCharArray()[0];
            char b = survey[i].toCharArray()[1];
            int track = position1.get(a);

            if(select > 4) {
                save.put(String.valueOf(b), save.get(String.valueOf(b)) + score.get(select));
            } else if(select < 4) {
                save.put(String.valueOf(a), save.get(String.valueOf(a)) + score.get(select));
            } else {
                continue;
            }

            System.out.println(save.get(String.valueOf(a)) + " / " + save.get(String.valueOf(b)));

            if(save.get(String.valueOf(a)) < save.get(String.valueOf(b))) {
                answer.setCharAt(track-1, survey[i].toCharArray()[1]);
            } else if(save.get(String.valueOf(a)) > save.get(String.valueOf(b))){
                answer.setCharAt(track-1, survey[i].toCharArray()[0]);
            } else {
                answer.setCharAt(track-1, position2.get(track));
            }
        }

        for(int i=0;i<4;i++) {
            if(String.valueOf(answer.charAt(i)).equals("-")) {
                answer.setCharAt(i, position2.get(i+1));
            }
        }

        return answer.toString();
    }
}
