package com.my.codingtest.programmers.level1;

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        // 4000

        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        // 120

        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        // 133

        System.out.println(solution(sizes3) + "");
    }

    public static int solution(int[][] sizes) {
        int answer = 0;

        int xMax = 0;
        int yMax = 0;
        for(int i=0;i<sizes.length;i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = tmp;
            }
            if(xMax < sizes[i][0]) {
                xMax = sizes[i][0];
            }
            if(yMax < sizes[i][1]) {
                yMax = sizes[i][1];
            }
        }

        answer = xMax * yMax;

        return answer;
    }
}
