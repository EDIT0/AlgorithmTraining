package com.my.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 로또의_최고_순위와_최저_순위 {

    public static void main(String[] args) {
        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] win_nums1 = {31, 10, 45, 1, 6, 19};
        // 3, 5

        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] win_nums2 = {38, 19, 20, 40, 15, 25};
        // 1, 6

        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};
        // 1, 1

        System.out.println(Arrays.toString(solution(lottos2, win_nums2)) + "");
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};

        answer = new int[2];

        int same = 0;
        int zero = 0;

        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<lottos.length;i++) {
            if(lottos[i] == 0) {
                zero += 1;
            } else {
                hashMap.put(lottos[i], 0);
            }
        }
        for(int i=0;i<win_nums.length;i++) {
            if(hashMap.containsKey(win_nums[i])) {
                same += 1;
            }
        }
//        for(int i=0;i<lottos.length;i++) {
//            if(lottos[i] == 0) {
//                zero += 1;
//            } else {
//                for(int j=0;j<win_nums.length;j++) {
//                    if(lottos[i] == win_nums[j]) {
//                        same += 1;
//                        break;
//                    }
//                }
//            }
//        }

        int max = 0;
        int min = 0;
        max = 7 - (same + zero);
        min = 7 - same;
        if(max > 5) {
            max = 6;
        }
        if(min > 5) {
            min = 6;
        }

//        switch (same + zero) {
//            case 6: {
//                max = 1;
//                break;
//            }
//            case 5: {
//                max = 2;
//                break;
//            }
//            case 4: {
//                max = 3;
//                break;
//            }
//            case 3: {
//                max = 4;
//                break;
//            }
//            case 2: {
//                max = 5;
//                break;
//            }
//            default: {
//                max = 6;
//                break;
//            }
//        }
//
//        switch (same) {
//            case 6: {
//                min = 1;
//                break;
//            }
//            case 5: {
//                min = 2;
//                break;
//            }
//            case 4: {
//                min = 3;
//                break;
//            }
//            case 3: {
//                min = 4;
//                break;
//            }
//            case 2: {
//                min = 5;
//                break;
//            }
//            default: {
//                min = 6;
//                break;
//            }
//        }

        answer[0] = max;
        answer[1] = min;

        return answer;
    }

}
