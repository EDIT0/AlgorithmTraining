package com.my.codingtest.programmers.level2;

import java.util.*;

public class DFS_타겟_넘버 {

    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        // 5

        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;
        // 2

        System.out.println(solution(numbers1, target1));
    }

    public static int count = 0;
    public static int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(numbers, target, 0, 0);
        answer = count;
        System.out.println("1. " + answer);

        count = 0;
        bfs(numbers, target);
        answer = count;
        System.out.println("2. " + answer);

        return answer;
    }

    public static void dfs(int[] numbers, int target, int depth, int sum) {
        if(numbers.length <= depth) {
            if(target == sum) {
                count += 1;
            }
            return;
        }
        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }

    public static void bfs(int[] numbers, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        for(int i=0;i<numbers.length;i++) {
            int size = queue.size();
            for(int j=0;j<size;j++) {
                int sum = queue.poll();
                queue.add(sum + numbers[i]);
                queue.add(sum - numbers[i]);
            }
        }

        while (!queue.isEmpty()) {
            if(target == queue.poll()) {
                count += 1;
            }
        }
    }

}
