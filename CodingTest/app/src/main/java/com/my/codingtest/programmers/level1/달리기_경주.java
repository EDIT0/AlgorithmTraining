package com.my.codingtest.programmers.level1;

import java.util.*;

public class 달리기_경주 {


    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(solution(players, callings)) + "");
    }

    public static String[] solution(String[] players, String[] callings) {
        String[] answer = {};

        answer = new String[players.length];

        Map<String, Integer> hashMap1 = new HashMap<>();

        for(int i=0;i< players.length;i++) {
            hashMap1.put(players[i], i);
        }

        for(int i=0;i< callings.length;i++) {
            int callNameRank = hashMap1.get(callings[i]);
            String callName = players[callNameRank];

            if(callNameRank != 0) {
                String tmp = players[callNameRank];
                players[callNameRank] = players[callNameRank - 1];
                players[callNameRank - 1] = tmp;

                hashMap1.put(players[callNameRank], callNameRank);
                hashMap1.put(players[callNameRank-1], callNameRank - 1);
            }
        }

        for(int i=0;i< players.length;i++) {
            int a = hashMap1.get(players[i]);
            answer[a] = players[a];
        }

        return answer;
    }

}
