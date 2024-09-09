package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 공원_산책 {

    public static void main(String[] args) {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};

        String[] park3 = {"OSO","OOO","OXO","OOO"};
        String[] routes3 = {"E 2","S 3","W 1"};

        System.out.println(Arrays.toString(solution(park3, routes3)) + "");
    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = {};

        final String S = "S";
        final String W = "W";
        final String N = "N";
        final String E = "E";

        String[][] arr = new String[park.length][park[0].length()];

        for (int i=0;i<park.length;i++) {
            for (int j=0;j<park[i].length();j++) {
                arr[i][j] = String.valueOf(park[i].charAt(j));
            }
        }


        int x = 0;
        int y = 0;

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
//                System.out.print(arr[i][j]);
                if(arr[i][j].equals("S")) {
                    x = i;
                    y = j;
                }
            }
//            System.out.println();
        }

        for(int i=0;i< routes.length;i++) {
            String[] routeArr = routes[i].split(" ");
            String direction = routeArr[0];
            int count = Integer.parseInt(routeArr[1]);

            switch (direction) {
                case S: {
                    if(arr.length > (x+count)) { // 길이가 넘어가는지 확인
                        for(int j=1;j<=count;j++) {
                            if(arr[x+j][y].equals("X")) { // 장애물이 있는지 확인
                                break;
                            } else {
                                if(j == count) {
                                    x = x+j;
                                }
                            }
                        }
                    }
                    break;
                }
                case W: {
                    if(-1 < (y-count)) {
                        for(int j=1;j<=count;j++) {
                            if(arr[x][y-j].equals("X")) {
                                break;
                            } else {
                                if(j == count) {
                                    y = y-j;
                                }
                            }
                        }
                    }
                    break;
                }
                case N: {
                    if(-1 < (x-count)) { // 길이가 넘어가는지 확인
                        for(int j=1;j<=count;j++) {
                            if(arr[x-j][y].equals("X")) { // 장애물이 있는지 확인
                                break;
                            } else {
                                if(j == count) {
                                    x = x-j;
                                }
                            }
                        }
                    }
                    break;
                }
                case E: {
                    if(arr[0].length > (y+count)) {
                        for(int j=1;j<=count;j++) {
                            if(arr[x][y+j].equals("X")) {
                                break;
                            } else {
                                if(j == count) {
                                    y = y+j;
                                }
                            }
                        }
                    }
                    break;
                }
                default: {

                }
            }
        }

        answer = new int[] { x, y };

        return answer;
    }

}
