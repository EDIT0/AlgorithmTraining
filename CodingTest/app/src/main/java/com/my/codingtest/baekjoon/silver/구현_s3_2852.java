package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 구현_s3_2852 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int totalMatchTime = 48 * 60;
            int state = 0;
            int leadTeam = 0;
            int team1Time = -1;
            int team2Time = -1;
            int answer1 = 0;
            int answer2 = 0;

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int team = Integer.parseInt(st.nextToken());
                String[] goalInTimeArr = st.nextToken().split(":");
                int goalInTime = (Integer.parseInt(goalInTimeArr[0]) * 60 + Integer.parseInt(goalInTimeArr[1]));

                // 상태 업데이트
                if(team == 1) {
                    state += 1;
                } else if(team == 2) {
                    state -= 1;
                }

                // 상태에 따른 분기
                if(state == 0) {
                    if(leadTeam == 2) { // 동점이 되었지만, 리드하고 있던 팀에 대한 시간 계산
                        answer2 += (goalInTime - team2Time);
                    } else if(leadTeam == 1) { // 동점이 되었지만, 리드하고 있던 팀에 대한 시간 계산
                        answer1 += (goalInTime - team1Time);
                    }
                    team1Time = -1;
                    team2Time = -1;
                    leadTeam = 0;
                } else if(state > 0) {
                    if(team1Time == -1) { // State가 0일 때 값을 -1으로 초기화 하므로, 이기기 시작한 시간이란 의미
                        team1Time = goalInTime;
                    }
                } else {
                    if(team2Time == -1) { // State가 0일 때 값을 -1으로 초기화 하므로, 이기기 시작한 시간이란 의미
                        team2Time = goalInTime;
                    }
                }

                if(state > 0) {
                    leadTeam = 1;
                } else if(state < 0) {
                    leadTeam = 2;
                }
            }

            // 마지막 끝날 때의 시간 계산
            if(state > 0) {
                answer1 += (totalMatchTime - team1Time);
            } else if(state < 0) {
                answer2 += (totalMatchTime - team2Time);
            }

            int team1Min = answer1 / 60;
            int team1Sec = answer1 % 60;
            int team2Min = answer2 / 60;
            int team2Sec = answer2 % 60;

            bw.write(String.format("%02d", team1Min) + ":" + String.format("%02d", team1Sec) + "\n");
            bw.write(String.format("%02d", team2Min) + ":" + String.format("%02d", team2Sec) + "\n");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
