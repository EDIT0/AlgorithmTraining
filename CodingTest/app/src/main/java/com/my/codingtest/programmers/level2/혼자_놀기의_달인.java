package com.my.codingtest.programmers.level2;

import java.util.*;

public class 혼자_놀기의_달인 {

    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        // 12

        System.out.println(solution(cards));
    }

    public static int solution(int[] cards) {
        int answer = 1;

        boolean[] visited = new boolean[cards.length];
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> maxNum = new ArrayList<Integer>();

        for(int i=1;i<=cards.length;i++) {
            int index = i-1;
            while (!visited[index]) {
                result.add(cards[index]);
                visited[index] = true;
                index = cards[index]-1;
            }
            maxNum.add(result.size());
            result.clear();
        }

        Collections.sort(maxNum, Collections.reverseOrder());
        for(int i=0;i<2;i++) {
            answer *= maxNum.get(i);
        }
//        for(int i=0;i<maxNum.size();i++) {
//            System.out.print(maxNum.get(i) + ", ");
//        }
//        System.out.println();

        return answer;
    }

}
