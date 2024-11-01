package com.my.codingtest.programmers.level2;

import java.util.*;

public class PCCP_석유_시추 {
    public static void main(String[] args) {
        int[][] land1 = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };
        // 7번째 9

        int[][] land2 = {
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}
        };
        // 6번째 16

        int[][] land3 = {
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 1, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 1}
        };

        int[][] land4 = {
                {1, 1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 1, 1, 0, 0}
        };

        System.out.println(solution(land2) + "");
    }

    public static int solution(int[][] land) {
        int answer = 0;

        boolean[][] visited = new boolean[land.length][land[0].length];
        int[] arr = new int[land[0].length];

        for(int i=0;i<land[0].length;i++) {
            for(int j=0;j<land.length;j++) {
                int point = land[j][i];
                if(point == 1 && !visited[j][i]) {
                    arr = bfs(j, i, land, visited, arr);
                }
            }
        }

        answer = Arrays.stream(arr).max().getAsInt();

        return answer;
    }

    public static int[] bfs(int x, int y, int[][] land, boolean[][] visited, int[] arr) {
        int totalCount = 0;
        Queue<int[]> linkedList = new LinkedList<int[]>();
        HashSet<Integer> hashSet = new HashSet<>();

        // x가 y축, y가 x축
        linkedList.offer(new int[] {x, y});

        visited[x][y] = true;
        totalCount += 1;

        // 방향 배열 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!linkedList.isEmpty()) {
            int[] tmpCurrentPoint = linkedList.poll();

            int tmpX = tmpCurrentPoint[0];
            int tmpY = tmpCurrentPoint[1];
            hashSet.add(tmpY);

            for(int i=0;i<4;i++) {
                int nx = tmpX + dx[i];
                int ny = tmpY + dy[i];

                // 경계 내에 있고, 방문하지 않았으며 land가 1인 경우만 탐색
                if (nx>=0 && nx<land.length && ny>=0 && ny<land[0].length && land[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    linkedList.offer(new int[]{nx, ny});
                    totalCount+=1;
                }
            }
        }
        for(int i : hashSet) {
            arr[i] += totalCount;
        }
        return arr;
    }

    /* 시간 초과된 코드 / HashSet을 사용해야 했다. */
//    public static int solution(int[][] land) {
//        int answer = 0;
//
//        boolean[][] visited;
//        Map<Integer, Integer> hashMap = new HashMap<>();
//
//        for(int i=0;i<land[0].length;i++) {
//            visited = new boolean[land.length][land[0].length];
//            for(int j=0;j<land.length;j++) {
//                int point = land[j][i];
//                if(point == 1 && !visited[j][i]) {
//                    hashMap = bfs(j, i, land, visited, hashMap);
//                }
//            }
//        }
//        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
//            answer = Math.max(answer, entry.getValue());
//        }
//
//        return answer;
//    }
//
//    public static Map<Integer, Integer> bfs(int x, int y, int[][] land, boolean[][] visited, Map<Integer, Integer> hashMap) {
//        int totalCount = 0;
//        Queue<int[]> linkedList = new LinkedList<int[]>();
//
//        // x가 y축, y가 x축
//        linkedList.offer(new int[] {x, y});
//
//        visited[x][y] = true;
//        totalCount += 1;
//
//        // 방향 배열 (상, 하, 좌, 우)
//        int[] dx = {-1, 1, 0, 0};
//        int[] dy = {0, 0, -1, 1};
//
//        while (!linkedList.isEmpty()) {
//            int[] tmpCurrentPoint = linkedList.poll();
//
//            int tmpX = tmpCurrentPoint[0];
//            int tmpY = tmpCurrentPoint[1];
//
////            int left = (tmpY-1 < 0) ? -1 : tmpY-1;
////            int right = (tmpY+1 == land[0].length) ? -1 : tmpY+1;
////            int top = (tmpX-1 < 0) ? -1 : tmpX-1;
////            int bottom = (tmpX+1 == land.length) ? -1 : tmpX+1;
//
//            for(int i=0;i<4;i++) {
//                int nx = tmpX + dx[i];
//                int ny = tmpY + dy[i];
//
//                // 경계 내에 있고, 방문하지 않았으며 land가 1인 경우만 탐색
//                if (nx>=0 && nx<land.length && ny>=0 && ny<land[0].length && land[nx][ny] == 1 && !visited[nx][ny]) {
//                    visited[nx][ny] = true;
//                    linkedList.offer(new int[]{nx, ny});
//                    totalCount+=1;
//                }
//            }
//        }
//        hashMap.put(y, hashMap.getOrDefault(y, 0) + totalCount);
//        return hashMap;
//    }
}
