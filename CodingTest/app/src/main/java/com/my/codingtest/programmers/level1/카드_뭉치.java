package com.my.codingtest.programmers.level1;

public class 카드_뭉치 {
    public static void main(String[] args) {
        String[] cards1_1 = {"i", "drink", "water"};
        String[] cards2_1 = {"want", "to"};
        String[] goal_1 = {"i", "want", "to", "drink", "water"};

        String[] cards1_2 = {"i", "water", "drink"};
        String[] cards2_2 = {"want", "to"};
        String[] goal_2 = {"i", "want", "to", "drink", "water"};


        System.out.println(solution(cards1_1, cards2_1, goal_1) + "");
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int cards1Index = 0;
        int cards2Index = 0;
        for(int i=0;i<goal.length;i++) {
            if(cards1.length > cards1Index && goal[i].equals(cards1[cards1Index])) {
                cards1Index++;
            } else if(cards2.length > cards2Index && goal[i].equals(cards2[cards2Index])) {
                cards2Index++;
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}
