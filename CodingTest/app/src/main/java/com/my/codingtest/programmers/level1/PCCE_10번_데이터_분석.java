package com.my.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class PCCE_10번_데이터_분석 {
    public static void main(String[] args) {
        int[][] data1 = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext1 = "date";
        int val_ext1 = 20300501;
        String sort_by1 = "remain";

        System.out.println(solution(data1, ext1, val_ext1, sort_by1) + "");
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        int order_ext = checkPosition(ext);
        int order_sort_by = checkPosition(sort_by);

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[order_sort_by] - o2[order_sort_by];
            }
        });

        answer = Arrays.stream(data)
                .filter(i -> {
                    return i[order_ext] < val_ext;
                })
                .toArray(int[][]::new);

//        ArrayList<int[]> result = new ArrayList<>();
//        for(int i=0;i<data.length;i++) {
//            if(val_ext > data[i][order_ext]) {
//                result.add(data[i]);
//            }
//        }
//
//        answer = new int[result.size()][];
//
//        for(int i=0;i<result.size();i++) {
//            answer[i] = result.get(i);
//        }

        return answer;
    }

    public static int checkPosition(String s) {
        int num = -1;
        switch (s) {
            case "code": {
                num = 0;
                break;
            }
            case "date": {
                num = 1;
                break;
            }
            case "maximum": {
                num = 2;
                break;
            }
            case "remain": {
                num = 3;
                break;
            }
        }
        return num;
    }
}
