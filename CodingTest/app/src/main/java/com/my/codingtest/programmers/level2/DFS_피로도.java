package com.my.codingtest.programmers.level2;

public class DFS_피로도 {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        // 3

        System.out.println(solution(k, dungeons));
    }

    public static boolean[] visited;
    public static int maxSum = 0;

    public static int solution(int k, int[][] dungeons) {
        int answer = 0;

        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);

        answer = maxSum;

        return answer;
    }

    // 완전탐색
    public static void dfs(int value, int[][] dungeons, int sum) {
        maxSum = Math.max(maxSum, sum);

        for(int i=0;i<dungeons.length;i++) {
            if(!visited[i] && value >= dungeons[i][0]) {
                visited[i] = true;
                dfs(value - dungeons[i][1], dungeons, sum + 1);
                visited[i] = false;
            }
        }
    }
}
