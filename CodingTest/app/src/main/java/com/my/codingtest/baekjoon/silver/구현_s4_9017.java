package com.my.codingtest.baekjoon.silver;

import java.util.*;
import java.io.*;

public class 구현_s4_9017 {

    public static class Model {
        int score;
        int addCount;

        Model(int score, int addCount) {
            this.score = score;
            this.addCount = addCount;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int T = Integer.parseInt(br.readLine());
            StringTokenizer st;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            List<Integer> inputList = new ArrayList<>();
            List<Integer> arrList = new ArrayList<>();
            Map<Integer, Model> map = new HashMap<>();
            Map<Integer, Integer> fiveMap = new HashMap<>();

            for(int i=0;i<T;i++) {
                int N = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine(), " ");

                hashMap.clear();
                inputList.clear();
                arrList.clear();
                map.clear();
                fiveMap.clear();

                // 팀에서 참가한 인원 저장
                for(int j=0;j<N;j++) {
                    int team = Integer.parseInt(st.nextToken());
                    hashMap.put(team, hashMap.getOrDefault(team, 0) + 1);
                    inputList.add(team);
                }

                // 6명 이상 팀만 arrList에 추가 (정확한 복사)
                for (int team : inputList) {
                    if (hashMap.get(team) >= 6) {
                        arrList.add(team);
                    }
                }

                Map<Integer, Integer> runnerCount = new HashMap<>();
                // 각 팀별 합산 계산
                for(int j=0;j<arrList.size();j++) {
                    int team = arrList.get(j);
                    int count = runnerCount.getOrDefault(team, 0);

                    if (count < 4) {
                        Model m = map.getOrDefault(team, new Model(0, 0));
                        m.score += (j+1); // 등수는 1부터 시작
                        m.addCount++;
                        map.put(team, m);
                    } else if (count == 4) {
                        fiveMap.put(team, j+1); // 등수 저장
                    }

                    runnerCount.put(team, count + 1);
                }

                // 최소 점수 팀들 추출
                int minScore = Integer.MAX_VALUE;
                List<Integer> sameList = new ArrayList<>();
                for (Map.Entry<Integer, Model> entry : map.entrySet()) {
                    int team = entry.getKey();
                    int score = entry.getValue().score;

                    if (score < minScore) {
                        sameList.clear();
                        sameList.add(team);
                        minScore = score;
                    } else if (score == minScore) {
                        sameList.add(team);
                    }
                }

                // 동점자 중 5번째 주자 등수 가장 작은 팀 선택
                int winner = sameList.get(0);
                int minFifth = fiveMap.get(winner);

                for (int team : sameList) {
                    int fifth = fiveMap.get(team);
                    if (fifth < minFifth) {
                        minFifth = fifth;
                        winner = team;
                    }
                }

                bw.write(winner + "\n");

//                System.out.println();
//                for(int j=0;j<fiveList.size();j++) {
//                    System.out.print(fiveList.get(j) + " / ");
//                }
//                System.out.println();
//                for(int j=0;j<sameList.size();j++) {
//                    System.out.print(sameList.get(j).score + " " + sameList.get(j).addCount + " / ");
//                }
//                System.out.println();
//                for(int j=0;j<inputList.size();j++) {
//                    System.out.print(inputList.get(j) + " ");
//                }
//                System.out.println();
//                for(Map.Entry<Integer, Model> entry : map.entrySet()) {
//                    System.out.println(entry.getKey() + " / " + entry.getValue().score + " / " + entry.getValue().addCount);
//                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
