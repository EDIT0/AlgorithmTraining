package com.my.codingtest.programmers.level2;

import java.util.*;

public class 합_교집합_뉴스_클러스터링_KAKAO {

    public static void main(String[] args) {
        String str1_1 = "FRANCE";
        String str2_1 = "french";
        // 16384

        String str1_2 = "handshake";
        String str2_2 = "shake hands";
        // 65536

        String str1_3 = "aa1+aa2";
        String str2_3 = "AAAA12";
        // 43690

        String str1_4 = "E=M*C^2";
        String str2_4 = "e=m*c^2";
        // 65536

        System.out.println(solution(str1_1, str2_1) + "");
    }

    public static int solution(String str1, String str2) {
        int answer = 0;

        /**
         * 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다.
         * 이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
         * 예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.
         * 다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. "AB"와 "Ab", "ab"는 같은 원소로 취급한다.
         */
        // {FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH} 2 / 8
        // {HA, AN, ND, DS, SH, HA, AK, KE}, {SH, HA, AK, KE, HA, AN, ND, DS} 8 / 8
        // {AA, AA}, {AA, AA, AA} 2 / 3
        // 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력

        HashMap<String, Integer> str1Map = new HashMap<>();
        HashMap<String, Integer> str2Map = new HashMap<>();

        for(int i=0;i<str1.length();i++) {
            if(i == str1.length()-1) {
                break;
            }

            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            if(((c1 >= 'A' && c1 <= 'Z') || (c1 >= 'a' && c1 <= 'z')) && ((c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z'))) {
                String s = str1.charAt(i) + "" + str1.charAt(i+1);
                str1Map.put(s.toUpperCase(), str1Map.getOrDefault(s.toUpperCase(), 0) + 1);
            }
        }

        for(int i=0;i<str2.length();i++) {
            if(i == str2.length()-1) {
                break;
            }

            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            if(((c1 >= 'A' && c1 <= 'Z') || (c1 >= 'a' && c1 <= 'z')) && ((c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z'))) {
                String s = str2.charAt(i) + "" + str2.charAt(i+1);
                str2Map.put(s.toUpperCase(), str2Map.getOrDefault(s.toUpperCase(), 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : str1Map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue() + " ");
        }
        System.out.println();
        for (Map.Entry<String, Integer> entry : str2Map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue() + " ");
        }
        System.out.println();

        // 교집합과 합집합 크기 구하기
        int intersection = 0; // 교집합 크기
        int union = 0;        // 합집합 크기

        // 교집합 구하기
        for (String key : str1Map.keySet()) {
            if (str2Map.containsKey(key)) {
                intersection += Math.min(str1Map.get(key), str2Map.get(key));
            }
        }

        // 합집합 구하기
        for (String key : str1Map.keySet()) {
            if (str2Map.containsKey(key)) {
                union += Math.max(str1Map.get(key), str2Map.get(key));
            } else {
                union += str1Map.get(key);
            }
        }

        // str2Map에만 있는 원소 추가
        for (String key : str2Map.keySet()) {
            if (!str1Map.containsKey(key)) {
                union += str2Map.get(key);
            }
        }

        // Jaccard 유사도 계산
        if (union == 0) {
            answer = 65536;
        } else {
            double jaccard = (double) intersection / union;
            answer = (int) (65536 * jaccard);
        }

        return answer;
    }

}
