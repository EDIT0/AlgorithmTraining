package com.my.codingtest.programmers.level1;

import java.util.*;

class 해시_완주하지_못한_선수 {

    public static void main(String[] args) {
        String[] participant = new String[] {"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[] {"stanko", "ana", "mislav"};

        System.out.println(solution1(participant, completion));
        System.out.println(solution2(participant, completion));
    }

    /**
     * HashMap 사용 O
     * */
    public static String solution1(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> totalHashMap = new HashMap<>();

        for(int i=0;i<participant.length;i++) {
            // 동명이인 숫자 세기
            if(totalHashMap.containsKey(participant[i])) {
                totalHashMap.put(participant[i], totalHashMap.get(participant[i]) + 1);
            } else {
                totalHashMap.put(participant[i], 1);
            }
        }

        for(int i=0;i<completion.length;i++) {
            // 완주한 사람 카운트 -1
            int peopleCount = totalHashMap.get(completion[i]);
            if(peopleCount > 0) {
                totalHashMap.put(completion[i], peopleCount -1);
            }
        }

        for(int i=0;i<participant.length;i++) {
            // 0이 아닌 사람이 완주 못한 사람
            if(totalHashMap.get(participant[i]) > 0) {
                answer = participant[i];
            }
        }

        return answer;
    }

    /**
     * HashMap 사용 X
     * */
    public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        answer = arrCal(participant, completion);

        return answer;
    }

    private static String arrCal(String[] participant, String[] completion) {
        String result = "";
        for(int i=0;i<completion.length;i++){
            if(participant[i].equals(completion[i])){
                continue;
            }
            else{
                result = participant[i];
                return result;
            }
        }

        if(result.equals("")){
            result = participant[participant.length-1];
            return result;
        }
        return result;
    }



}