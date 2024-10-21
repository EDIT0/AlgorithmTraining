package com.my.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 정렬_K번째수 {

    public static void main(String[] args) {
        int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][] {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        System.out.println(Arrays.toString(solution(array, commands)) + "");
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        int[] newArray;
        ArrayList<Integer> result = new ArrayList<>();
        for(int a=0;a<commands.length;a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];

            newArray = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(newArray);
            result.add(newArray[k-1]);
        }

        answer = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            answer[i] = result.get(i);
        }

//        ArrayList<Integer> result = new ArrayList<>();
//
//        answer = new int[commands.length];
//        for(int i=0;i<commands.length;i++) {
////            ArrayList<Integer> splitList = new ArrayList<>();
////            for(int j=commands[i][0]-1;j<=commands[i][1]-1;j++) {
////                splitList.add(array[j]);
////            }
////
////            Collections.sort(splitList);
////            result.add(splitList.get(commands[i][2]-1));
//
//            int[] splitList = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
//            Arrays.sort(splitList);
//            answer[i] = splitList[commands[i][2]-1];
//        }
//
////        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

}
