package com.my.codingtest.programmers.level3;

import java.util.*;

public class BFS_DFS_단어_변환 {


    public static void main(String[] args) {
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        // 4

        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};
        // 0

        System.out.println(solution(begin1, target1, words1));
    }

    public static Queue<Pointer> queue = new LinkedList<>();
    public static boolean[] visited;
    public static int count = 0;

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean isExist = false;
        for(int i=0;i<words.length;i++) {
            if(target.equals(words[i])) {
                isExist = true;
            }
        }
        if(!isExist) {
            answer = 0;
            return answer;
        }

        visited = new boolean[words.length];
        bfs(begin, target, words);

        answer = count;
        System.out.println("bfs answer: " + answer);

        // =========== bfs, dfs

        isExist = false;
        for(int i=0;i<words.length;i++) {
            if(target.equals(words[i])) {
                isExist = true;
            }
        }
        if(!isExist) {
            answer = 0;
            return answer;
        }

        visited = new boolean[words.length];
        count = words.length + 1;
        dfs(begin, target, words, 0);

        answer = count;
        System.out.println("dfs answer: " + answer);

        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int dfsCount) {
        if(begin.equals(target)) {
            count = Math.min(count, dfsCount);
            System.out.println("정답: " + begin + " / dfsCount: " + dfsCount + " / count: " + count);
            return;
        }
        for(int i=0;i<words.length;i++) {
            if(!visited[i] && diff(begin, words[i]) == 1) {
                visited[i] = true;
                dfs(words[i], target, words, dfsCount + 1);
                visited[i] = false; // 백트래킹, 모든 경우의 수를 보기 위해 추가
            }
        }
    }

    public static void bfs(String begin, String target, String[] words) {
        queue.add(new Pointer(begin, target, 0));

        while (!queue.isEmpty()) {
            Pointer pointer = queue.poll();

            if(pointer.begin.equals(target)) {
                System.out.println("정답: " + pointer.begin + " / " + pointer.count);
                count = pointer.count;
                break;
            }

            for(int i=0;i<words.length;i++) {
                if(!visited[i] && diff(pointer.begin, words[i]) == 1) {
                    queue.add(new Pointer(words[i], target, pointer.count + 1));
                    visited[i] = true;
                }
            }
        }
    }

    public static int diff(String a, String b) {
        // 길이는 동일 비교x
        int d = 0;
        for(int i=0;i<a.length();i++) {
            if(a.charAt(i) != b.charAt(i)) {
                d += 1;
            }
        }

        return d;
    }

    public static class Pointer {
        String begin;
        String target;
        int count;

        public Pointer(String begin, String target, int count) {
            this.begin = begin;
            this.target = target;
            this.count = count;
        }
    }

}
