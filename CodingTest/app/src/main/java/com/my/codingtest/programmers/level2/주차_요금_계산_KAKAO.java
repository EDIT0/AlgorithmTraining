package com.my.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 주차_요금_계산_KAKAO {

    public static void main(String[] args) {
        int[] fees1 = {180, 5000, 10, 600};
        String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        // {14600, 34400, 5000}

        int[] fees2 = {120, 0, 60, 591};
        String[] records2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        // {0, 591}

        int[] fees3 = {1, 461, 1, 10};
        String[] records3 = {"00:00 1234 IN"};
        // {14841}

        System.out.println(Arrays.toString(solution(fees1, records1)));
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, Integer> timeMap = new HashMap<>();
        Map<String, Integer> stayTimeMap = new HashMap<>();
        Map<String, String> inOutMap = new HashMap<>();

        for(int i=0;i<records.length;i++) {
            String[] info = records[i].split(" ");
            int time = timeToMinute(info[0]);
            String carNumber = info[1];
            String state = info[2];

            String inOut = inOutMap.get(carNumber);
            System.out.println(carNumber + " / " + time + " / " + state + " / " + inOut);
            if(inOut == null) {
                // 첫 입차
                timeMap.put(carNumber, time);
                stayTimeMap.put(carNumber, 0);
                inOutMap.put(carNumber, state);
            } else {
                if(state.equals("IN")) {
                    // 재입차
                    timeMap.put(carNumber, time);
                    inOutMap.put(carNumber, state);
                } else {
                    // 출차
                    System.out.println(carNumber + " / 입차: " + timeMap.get(carNumber) +" / 출차: " + time);
                    stayTimeMap.put(carNumber, calInOutTime(timeMap.get(carNumber), time) + stayTimeMap.get(carNumber));
                    timeMap.put(carNumber, time);
                    inOutMap.put(carNumber, state);
                }
            }
        }

        List<String> inOutKeyList = new ArrayList<>(inOutMap.keySet());
        List<String> inOutValueList = new ArrayList<>(inOutMap.values());
        for(int i=0;i<inOutKeyList.size();i++) {
            // 출차 기록이 없는 차는 23:59 기준으로 계산
            if(inOutValueList.get(i).equals("IN")) {
                stayTimeMap.put(inOutKeyList.get(i), calInOutTime(timeMap.get(inOutKeyList.get(i)), timeToMinute("23:59")) + stayTimeMap.get(inOutKeyList.get(i)));
            }
        }

        System.out.println(stayTimeMap);

        answer = new int[stayTimeMap.size()];
        List<String> stayTimeKeyList = new ArrayList<>(stayTimeMap.keySet());
        Collections.sort(stayTimeKeyList); // 차번호 오름차순으로 정렬
        int answerIndex = 0;
        for(String key : stayTimeKeyList) {
            int totalPrice = 0;
            int remainTime = stayTimeMap.get(key).intValue() - fees[0];
            totalPrice = fees[1];

            if(remainTime > 0) {
                int tmp = remainTime / fees[2];
                totalPrice += (tmp * fees[3]);

                if(remainTime % fees[2] != 0) {
                    totalPrice += fees[3];
                }
            }

            answer[answerIndex] = totalPrice;
            answerIndex += 1;
        }


        return answer;
    }

    public static int timeToMinute(String time) {
        int minute = 0;

        String[] t = time.split(":");
        minute = Integer.parseInt(t[0])*60;
        minute += Integer.parseInt(t[1]);

        return minute;
    }

    public static int calInOutTime(Integer in, Integer out) {
        return out - in;
    }

}
