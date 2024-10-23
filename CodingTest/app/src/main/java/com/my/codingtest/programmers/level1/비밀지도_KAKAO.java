package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 비밀지도_KAKAO {

    public static void main(String[] args) {
        int n1 = 5;
        int[] arr1_1 = {9, 20, 28, 18, 11};
        int[] arr2_1 = {30, 1, 21, 17, 28};
        // 	["#####","# # #", "### #", "# ##", "#####"]

        int n2 = 6;
        int[] arr1_2 = {46, 33, 33 ,22, 31, 50};
        int[] arr2_2 = {27 ,56, 19, 14, 14, 10};
        // ["######", "### #", "## ##", " #### ", " #####", "### # "]

        System.out.println(Arrays.toString(solution(n1, arr1_1, arr2_1)) + "");
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};

        answer = new String[n];


        for(int i=0;i<n;i++) {
            String x = String.format("%"+n+"s", Integer.toBinaryString(arr1[i]));
            x = x.replace(' ', '0');
            String y = String.format("%"+n+"s", Integer.toBinaryString(arr2[i]));
            y = y.replace(' ', '0');

            String result = "";
            for(int j=0;j<n;j++) {
                if(x.charAt(j) == '0' && y.charAt(j) == '0') {
                    result += " ";
                } else {
                    result += "#";
                }
            }
            answer[i] = result;
        }

        return answer;
    }

}
