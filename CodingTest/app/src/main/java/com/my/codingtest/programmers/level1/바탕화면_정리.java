package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 바탕화면_정리 {

    public static void main(String[] args) {
        String[] wallpaper1 = {".#...", "..#..", "...#."};
        String[] wallpaper2 = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        String[] wallpaper3 = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        String[] wallpaper4 = {"..", "#."};

        System.out.println(Arrays.toString(solution(wallpaper4)) + "");
    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = {};

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i=0;i< wallpaper.length;i++) {
            for(int j=0;j<wallpaper[0].length();j++) {
//                System.out.print(wallpaper[i].charAt(j) + " ");
                if(String.valueOf(wallpaper[i].charAt(j)).equals("#")) {
                    if(maxX <= i) {
                        maxX = i;
                    }
                    if(maxY <= j) {
                        maxY = j;
                    }
                    if(minX >= i) {
                        minX = i;
                    }
                    if(minY >= j) {
                        minY = j;
                    }
                }
            }
//            System.out.println();
        }

//        System.out.println(minX + "/" + minY + " | " + maxX + "/" + maxY);

        answer = new int[] { minX, minY, maxX+1, maxY+1 };

        return answer;
    }
}
