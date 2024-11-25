package com.my.codingtest.programmers.level2;

import java.util.ArrayList;

public class 하노이의_탑 {

    public static ArrayList<int[]> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        int n1 = 3;

        System.out.println(solution(n1));
    }

    public static int[][] solution(int n) {
        int[][] answer = {};

        hanoiTop(n, 1, 2, 3);

        answer = new int[arrayList.size()][2];

        for(int i=0;i<arrayList.size();i++) {
//            System.out.println(arrayList.get(i)[0] + " " + arrayList.get(i)[1]);
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    public static void hanoiTop(int n, int start, int mid, int end) {
        if (n == 0) {
            return;
        }

        // n-1 start to mid (end를 보조 기둥으로 사용)
        hanoiTop(n - 1, start, end, mid);
        arrayList.add(new int[] {start, end});
        // n-1 mid to end (start를 보조 기둥으로 사용)
        hanoiTop(n - 1, mid, start, end);
    }
    
}
