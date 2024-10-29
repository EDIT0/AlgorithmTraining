package com.my.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PCCP_충돌위험_찾기 {

    public static void main(String[] args) {
        int[][] points1 = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes1 = {{4, 2}, {1, 3}, {2, 4}};
        // 1

        int[][] points2 = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes2 = {{4, 2}, {1, 3}, {4, 2}, {4, 3}};
        // 9

        int[][] points3 = {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
        int[][] routes3 = {{2, 3, 4, 5}, {1, 3, 4, 5}};
        // 0

        System.out.println(solution(points3, routes3) + "");
    }

    public static int solution(int[][] points, int[][] routes) {
        int answer = 0;

        ArrayList<Map<Integer, String>> saveRoute = new ArrayList<>();

        for(int i=0;i<routes.length;i++) {
            int pointY = -1;
            int pointX = -1;
            int destinationY = -1;
            int destinationX = -1;

            Map<Integer, String> map = new HashMap<>();
            int seconds = 0;

            for(int j=0;j<routes[0].length;j++) {
                if(pointY != -1 && pointX != -1) {
                    destinationY = points[routes[i][j]-1][0];
                    destinationX = points[routes[i][j]-1][1];
                } else {
                    pointY = points[routes[i][j]-1][0];
                    pointX = points[routes[i][j]-1][1];
                }
//                System.out.println(pointY +"/" + pointX + " To " + destinationY +"/" + destinationX);

                if(pointY != -1 && pointX != -1 && destinationY != -1 && destinationX != -1) {

                    if(pointY < destinationY) {
                        if(seconds == 0) {
                            for(int k=pointY;k<=destinationY;k++) {
                                map.put(seconds, k + "," + pointX);
                                seconds += 1;
                            }
                        } else {
                            for(int k=pointY+1;k<=destinationY;k++) {
                                map.put(seconds, k + "," + pointX);
                                seconds += 1;
                            }
                        }
                    } else if(pointY > destinationY) {
                        if(seconds == 0) {
                            for(int k=pointY;k>=destinationY;k--) {
                                map.put(seconds, k + "," + pointX);
                                seconds += 1;
                            }
                        } else {
                            for(int k=pointY-1;k>=destinationY;k--) {
                                map.put(seconds, k + "," + pointX);
                                seconds += 1;
                            }
                        }
                    }

                    if(pointX < destinationX) {
                        if(seconds == 0) {
                            for(int k=pointX;k<=destinationX;k++) {
                                map.put(seconds, destinationY + "," + k);
                                seconds += 1;
                            }
                        } else {
                            for(int k=pointX+1;k<=destinationX;k++) {
                                map.put(seconds, destinationY + "," + k);
                                seconds += 1;
                            }
                        }
                    } else if(pointX > destinationX) {
                        if(seconds == 0) {
                            for(int k=pointX;k>=destinationX;k--) {
                                map.put(seconds, destinationY + "," + k);
                                seconds += 1;
                            }
                        } else {
                            for(int k=pointX-1;k>=destinationX;k--) {
                                map.put(seconds, destinationY + "," + k);
                                seconds += 1;
                            }
                        }
                    }

                    pointY = destinationY;
                    pointX = destinationX;
                    destinationY = -1;
                    destinationX = -1;
                } else {

                }
            }
            saveRoute.add(map);
        }

//        for(int i=0;i<saveRoute.size();i++) {
//            System.out.println(saveRoute.get(i));
//        }

        int key = 0;
        while (true) {
            int endCount = 0;
            String[] e = new String[saveRoute.size()];
            for(int i=0;i<saveRoute.size();i++) {
                if(saveRoute.get(i).containsKey(key)) {
                    e[i] = saveRoute.get(i).get(key);
                } else {
                    endCount += 1;
                }
            }
            if(saveRoute.size() == endCount) break;

            Map<String, Integer> frequencyMap = new HashMap<>();
//            System.out.println("도는 횟수: " + e.length);
            for(int i=0;i<e.length;i++) {
                if(frequencyMap.containsKey(e[i])) {
                    if(e[i] != null) {
                        frequencyMap.put(e[i], frequencyMap.get(e[i]) + 1);
                    }
//                    System.out.println("중복 기존 " + e[i]);
                } else {
                    if(e[i] != null) {
                        frequencyMap.put(e[i], 1);
                    }
//                    System.out.println("중복 새로 등록 " + e[i]);
                }
            }

            for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
                if(entry.getValue() > 1) {
                    answer += 1;
                }
            }

            key += 1;
        }



        return answer;
    }

}
