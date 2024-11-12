package com.my.codingtest.programmers.level2;

import java.util.Arrays;

public class 연속된_부분_수열의_합_투_포인터 {

    public static void main(String[] args) {
        int[] sequence1 = {1, 2, 3, 4, 5};
        int k1 = 7;
        // 2,3
        int[] sequence2 = {1, 1, 1, 2, 3, 4, 5};
        int k2 = 5;
        // 6,6
        int[] sequence3 = {2, 2, 2, 2, 2};
        int k3 = 6;
        // 0,2

        System.out.println(Arrays.toString(solution(sequence1, k1)));
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = {};

        answer = new int[] {-1, -1};

        int[] sumSequence = new int[sequence.length];
        int s = 0;
        for(int i=0;i<sequence.length;i++) {
            s += sequence[i];
            sumSequence[i] = s;
        }
        System.out.println(Arrays.toString(sumSequence));

        int sum = 0;
        int start = 0;
        int end = 0;

        while (true) {
            if(end == sequence.length) {
                System.out.println("이줄에는 없는듯.. ");
                break;
            }

            if(start == 0) {
                sum = sumSequence[end];
            } else {
                sum = sumSequence[end] - sumSequence[start-1];
            }

            if(sum < k) {
                end += 1;
            } else if(sum > k) {
                start += 1;
            } else {
                if(answer[0] == -1) {
                    answer[0] = start;
                    answer[1] = end;
                } else if(answer[1] - answer[0] > end - start) {
                    answer[0] = start;
                    answer[1] = end;
                } else if(answer[1] - answer[0] == end - start) {
                    if(answer[0] > start) {
                        answer[0] = start;
                        answer[1] = end;
                    }
                }

                System.out.println("!! 같음! 저장 " + start +" / " + end);
                end += 1;
            }
        }

//        Map<Integer, String> hashMap = new HashMap<>();
//
//        boolean key = true;
//
//        for(int i=0;i<sequence.length;i++) {
//            if(!key) break;
//            int start = 0;
//            int end = sequence.length - 1;
//            while (start <= end) {
//                int mid = (start + end) / 2;
//                int a = mid + i;
//                if(a >= sequence.length) break;
//                int sum = 0;
//                for(int j=mid;j<=a;j++) {
//                    sum += sequence[j];
//                }
//                if(sum == k) {
//                    System.out.println(mid + "/" + a);
//                    break;
//                } else if(sum > k) {
//                    end = mid + 1;
//                } else if(sum < k) {
//                    start = mid + 1;
//                }
//                System.out.println(start +"/" +end + "/" + a);
//            }
//        }

//        answer = new int[2];
//
//        boolean key = true;
//
//        for(int i=0;i<sequence.length;i++) {
//            if(!key) break;
//            int point1 = 0;
//            int point2 = i;
//            while (true) {
//                int sum = 0;
//                for(int j=point1;j<=point2;j++) {
//                    sum += sequence[j];
//                }
//                if(sum > k) break;
//                if(sum == k) {
//                    answer[0] = point1;
//                    answer[1] = point2;
//                    key = false;
//                    break;
//                } else {
//                    point1 += 1;
//                    point2 += 1;
//                    if(point2 == sequence.length) {
//                        break;
//                    }
//                }
//            }
//        }

        return answer;
    }

}
