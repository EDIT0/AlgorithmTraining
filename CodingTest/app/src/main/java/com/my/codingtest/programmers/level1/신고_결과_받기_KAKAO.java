package com.my.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 신고_결과_받기_KAKAO {
    public static void main(String[] args) {
        String[] id_list_1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report_1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k_1 = 2;
        // 2,1,1,0

        String[] id_list_2 = {"con", "ryan"};
        String[] report_2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k_2 = 3;
        // 0,0

        String[] id_list_3 = {"a", "ab", "abc", "b"};
        String[] report_3 = {"ab a", "abc a", "b a", "a ab", "abc ab", "b ab", "a b"};
        int k_3 = 2;

        System.out.println(solution(id_list_3, report_3, k_3) + "");
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        Map<String, Integer> reportCountHashMap = new HashMap<>(); // 신고 당한 자, 신고 당한 횟수
        Map<String, String> reportListHashMap = new HashMap<>(); // 신고자, 신고한 자 " " 기준으로 추가
        Map<String, Integer> mailSender = new HashMap<>(); // 신고자, 메일 갯수
        answer = new int[id_list.length];

        for(int i=0;i<id_list.length;i++) {
            reportCountHashMap.put(id_list[i], 0);
            reportListHashMap.put(id_list[i], "");
        }

        for(int i=0;i<report.length;i++) {
            String[] arr = report[i].split(" ");
            String a = arr[0]; // 신고자
            String b = arr[1]; // 신고 당한 자

            boolean key = false;
            String[] banArr = reportListHashMap.get(a).split(" "); // a가 신고한 애들 배열
            for(int j=0;j<banArr.length;j++) {
                if(b.equals(banArr[j])) {
                    key = true;
                }
            }

            if(!key) {
                reportCountHashMap.put(b, reportCountHashMap.get(b) + 1);
                reportListHashMap.put(a, reportListHashMap.get(a) + " " + b);
            }
        }

        ArrayList<String> ban = new ArrayList<>();

        for(Map.Entry<String, Integer> data : reportCountHashMap.entrySet()) {
            if(data.getValue() >= k) {
                ban.add(data.getKey());
            }
        }

        for(int j=0;j<id_list.length;j++) {
            for(int i=0;i<ban.size();i++) {
                String[] findArr = reportListHashMap.get(id_list[j]).split(" ");
                for(int n=0;n<findArr.length;n++) {
                    if(findArr[n].equals(ban.get(i))) {
                        if(mailSender.containsKey(id_list[j])) {
                            mailSender.put(id_list[j], mailSender.get(id_list[j]) + 1);
                        } else {
                            mailSender.put(id_list[j], 1);
                        }
                    }
                }
            }
        }

        for(int i=0;i<id_list.length;i++) {
            if(mailSender.get(id_list[i]) == null) {
                answer[i] = 0;
            } else {
                answer[i] = mailSender.get(id_list[i]);
            }
        }

        return answer;
    }
}
