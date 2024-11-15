package com.my.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;

public class 광물_캐기 {

    public static void main(String[] args) {
        int[] picks1 = {1, 3, 2};
        String[] minerals1 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        // 12

        int[] picks2 = {0, 1, 1};
        String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        // 50

        int[] picks3 = {0,1,0};
        String[] minerals3 = {"diamond", "iron", "iron", "iron", "iron", "diamond", "diamond", "iron", "iron", "iron"};
        // 9

        System.out.println(solution(picks1, minerals1));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        /**
         * 곡괭이를 하나 선택해서 광물 5개를 연속으로 캐고,
         * 다음 곡괭이를 선택해서 광물 5개를 연속으로 캐는 과정을 반복하며,
         * 더 사용할 곡괭이가 없거나 광산에 있는 모든 광물을 캘 때까지 과정을 반복하면 됩니다.
         * 다이아, 철, 돌 순으로 곡괭이 수 picks
         */

        // 계산할 범위 구하기
        int totalPickCount = 0;
        for(int i=0;i<picks.length;i++) {
            totalPickCount += picks[i];
        }
        totalPickCount *= 5;

        int totalCount = 0;
        if(totalPickCount > minerals.length) {
            totalCount = minerals.length;
        } else {
            totalCount = totalPickCount;
        }

        // 갯수 세기
        ArrayList<int[]> groupList = new ArrayList<>();
        int[] tmpInt = new int[3];
        for(int i=0;i<totalCount;i++) {
            if("diamond".equals(minerals[i])) {
                tmpInt[0]++;
            } else if("iron".equals(minerals[i])) {
                tmpInt[1]++;
            } else {
                tmpInt[2]++;
            }
            if(i%5==4 || i == totalCount-1) {
                groupList.add(tmpInt);
                tmpInt = new int[3];
            }
        }
        System.out.println(groupList.size());

        for(int i=0;i<groupList.size();i++) {
            for(int j=0;j<groupList.get(i).length;j++) {
                System.out.print(groupList.get(i)[j] + " ");
            }
            System.out.println();
        }

        // 정렬 (다이아 많은 순부터..)
        Collections.sort(groupList, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o2[0], o1[0]);
        });

        System.out.println("정렬 후");
        for(int i=0;i<groupList.size();i++) {
            for(int j=0;j<groupList.get(i).length;j++) {
                System.out.print(groupList.get(i)[j] + " ");
            }
            System.out.println();
        }


        int index = 0;
        for(int j=0;j<picks.length;j++) {
            int pickCount = picks[j];
            if (pickCount == 0) {
                continue;
            }

            while (pickCount > 0) {
                if(groupList.size() == index) {
                    break;
                }
                int[] group = groupList.get(index);

                pickCount -= 1;
                int dia = group[0];
                int ir = group[1];
                int st = group[2];
                if (j == 0) {
                    answer += (1 * dia);
                    answer += (1 * ir);
                    answer += (1 * st);
                } else if (j == 1) {
                    answer += (5 * dia);
                    answer += (1 * ir);
                    answer += (1 * st);
                } else {
                    answer += (25 * dia);
                    answer += (5 * ir);
                    answer += (1 * st);
                }

                index += 1;
            }
        }

        return answer;
    }

}
