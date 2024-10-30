package com.my.codingtest.programmers.level2;

import java.util.*;

public class 도넛과_막대_그래프_KAKAO {

    public static void main(String[] args) {
        int[][] edges1 = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
        // [2, 1, 1, 0]

        int[][] edges2 = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
        // [4, 0, 1, 2]

        System.out.println(Arrays.toString(solution(edges2)) + "");
    }

    public static int[] solution(int[][] edges) {
        int[] answer = {};

        answer = new int[4];

        // 크기가 n인 도넛 모양 그래프는 n개의 정점과 n개의 간선
        // 크기가 n인 막대 모양 그래프는 n개의 정점과 n-1개의 간선
        // 크기가 n인 8자 모양 그래프는 2n+1개의 정점과 2n+2개의 간선
        // 도넛 모양 그래프, 막대 모양 그래프, 8자 모양 그래프의 수의 합은 2이상

        Map<Integer, Integer> intIntMap = new HashMap<>();
        Map<Integer, Integer> intIntMap2 = new HashMap<>();

        // 임의로 만들어진 정점 찾기
        for(int i=0;i<edges.length;i++) {
            if(intIntMap.containsKey(edges[i][0])) {
                intIntMap.put(edges[i][0], intIntMap.get(edges[i][0])+1);
            } else {
                intIntMap.put(edges[i][0], 1);
            }

            if(intIntMap2.containsKey(edges[i][1])) {
                intIntMap2.put(edges[i][1], intIntMap2.get(edges[i][1])+1);
            } else {
                intIntMap2.put(edges[i][1], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : intIntMap.entrySet()) {
            if(!intIntMap2.containsKey(entry.getKey())) {
                if(entry.getValue() >= 2) {
                    answer[0] = entry.getKey();
                    System.out.println("만들어진 정점 : " + entry.getKey());
                }
            }
        }

        // 총 그래프 갯수 찾기
        ArrayList<String> graphCount = new ArrayList<>();
        for(int i=0;i<edges.length;i++) {
            if(edges[i][0] == answer[0]) {
                graphCount.add(edges[i][0]+","+edges[i][1]);
            }
        }
        System.out.println("그래프 갯수 : " + graphCount.size());

        // 막대 모양 그래프 찾기
        intIntMap.clear();
        intIntMap2.clear();
        for(int i=0;i<edges.length;i++) {
            intIntMap.put(edges[i][0], 0);
            intIntMap2.put(edges[i][1], 0);
        }
        for(Map.Entry<Integer, Integer> entry : intIntMap.entrySet()) {
            intIntMap2.remove(entry.getKey());
        }
        for(Map.Entry<Integer, Integer> entry : intIntMap2.entrySet()) {
            answer[2] = answer[2]+1;
            System.out.println("막대 모양 그래프 : "+ entry.getKey() + " / " + entry.getValue());
        }

        // 8자 모양 그래프 찾기
        intIntMap.clear();
        for(int i=0;i<edges.length;i++) {
            if(answer[0] != edges[i][0]) {
                if(intIntMap.containsKey(edges[i][0])) {
                    intIntMap.put(edges[i][0], intIntMap.get(edges[i][0])+1);
                } else {
                    intIntMap.put(edges[i][0], 1);
                }

                if(intIntMap.containsKey(edges[i][1])) {
                    intIntMap.put(edges[i][1], intIntMap.get(edges[i][1])+1);
                } else {
                    intIntMap.put(edges[i][1], 1);
                }
            }
        }
        for(Map.Entry<Integer, Integer> entry : intIntMap.entrySet()) {
            if(entry.getValue() >= 4) {
                answer[3] = answer[3]+1;
                System.out.println("8자 모양 그래프 : " + entry.getKey() + " / " + entry.getValue());
            }
        }

        answer[1] = graphCount.size() - answer[2] - answer[3];

        return answer;
    }


}
