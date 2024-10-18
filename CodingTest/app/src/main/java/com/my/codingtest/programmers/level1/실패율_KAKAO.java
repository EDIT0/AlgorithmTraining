package com.my.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 실패율_KAKAO {
    public static void main(String[] args) {
        int N1 = 5;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        // 3,4,2,1,5

        int N2 = 4;
        int[] stages2 = {4,4,4,4,4};
        // 4,1,2,3

        int N3 = 5;
        int[] stages3 = {2, 6, 2, 6, 2, 4, 3, 3};
        // 3,2,4,1,5

        int N4 = 2;
        int[] stage4 = {3};
        // 1,2

        System.out.println(Arrays.toString(solution(N4, stage4)) + "");
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = {};

        answer = new int[N];

        int user = stages.length;

        Arrays.sort(stages);

        List<Solution.Pair> pairList = new ArrayList<>();
        int[] result = new int[N]; // 결과

        int currentStage = -1;
        int currentStageUser = 0;
        for(int i=0;i<stages.length;i++) {
            if(stages[i] > N) {
                break;
            }
            if(currentStage == stages[i]) {
                currentStageUser += 1;
            } else {
                if(currentStage == -1) {
                    currentStageUser += 1;
                    currentStage = stages[i];
                } else {
                    // 이전 단계에 대한 계산
                    double d = (double) currentStageUser / user;
                    user -= currentStageUser;
                    pairList.add(new Solution.Pair(currentStage, d));

                    currentStageUser = 1;
                    currentStage = stages[i];
                }
            }
        }
        if(currentStage != -1) {
            // 이전 단계에 대한 계산
            double d = (double) currentStageUser / user;
            user -= currentStageUser;
            pairList.add(new Solution.Pair(currentStage, d));
        }

        // 값이 있는 스테이지에 대한 내림차순 정렬
        pairList.sort((o1, o2) -> {
            return Double.compare(o2.fail, o1.fail);
        });

        // result에 값이 있는 스테이지는 1을 넣어준다. (빈 스테이지 찾기 위함)
        System.out.println(result.length + " / " + pairList.size());
        for(int i=0;i<pairList.size();i++) {
            result[pairList.get(i).stage-1] = 1;
        }

        int[] remainResult = new int[N - pairList.size()]; // 빈 스테이지 결과

        // 빈 스테이지를 remainResult에 넣어준다.
        int index = 0;
        for(int i=0;i<result.length;i++) {
            if(result[i] == 0) {
                remainResult[index] = i+1;
                index++;
            }
        }

//        for(int i=0;i<pairList.size();i++) {
//            System.out.println(pairList.get(i).component1() + " / " + pairList.get(i).component2());
//        }
//        System.out.println();
//        for(int i=0;i<remainResult.length;i++) {
//            System.out.println(remainResult[i]);
//        }

        // 값이 있는 스테이지와 빈 스테이지를 합친다.
        for(int i=0;i<pairList.size();i++) {
            answer[i] = pairList.get(i).stage;
        }

        for(int i=0;i<remainResult.length;i++) {
            answer[pairList.size() + i] = remainResult[i];
        }

//        Map<Integer, Double> hashMap = new HashMap<>();
//        for(int i=0;i<N;i++) {
//            hashMap.put(i+1, 0.0);
//        }
//
//        int currentLevel = 0;
//        int currentLevelUser = 0;
//        for(int i=0;i<stages.length;i++) {
//            currentLevel = stages[i];
//            if(N < currentLevel) {
//                break;
//            }
//
//            currentLevelUser += 1;
//
//            if(stages.length-1 != i && currentLevel != stages[i+1]) {
//                double d = (double) currentLevelUser / user;
//                hashMap.put(currentLevel, d);
//                user -= currentLevelUser;
//
//                currentLevelUser = 0;
//            } else if(stages.length-1 != i && currentLevel == stages[i+1]) {
//
//            } else {
//                double d = (double) currentLevelUser / user;
//                hashMap.put(currentLevel, d);
//                currentLevelUser = 0;
//            }
//        }
//
//        for(Map.Entry<Integer, Double> entry : hashMap.entrySet()) {
//            System.out.print(entry.getKey() + "/" + entry.getValue() + " ");
//        }
//
//        System.out.println();
//        hashMap.entrySet()
//                .stream()
//                .sorted(comparingByValue())
//                .forEach( entry -> {
//                    System.out.print(entry.getKey() + "/" + entry.getValue() + " ");
//                });

        return answer;
    }

    public static class Pair {
        int stage;
        double fail;

        Pair(int s, double f) {
            stage = s;
            fail = f;
        }
    }
}
