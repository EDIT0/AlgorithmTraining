package com.my.codingtest.programmers.level2;

import java.util.*;

public class DFS_소수_찾기 {

    public static void main(String[] args) {
        String numbers1 = "17";
        // 3

        String numbers2 = "011";
        // 2

        System.out.println(solution(numbers2));
    }

    public static int count = 0;
    public static Map<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();

    public static int solution(String numbers) {
        int answer = 0;

        boolean[] visited = new boolean[numbers.length()];
        for(int i=0;i<numbers.length();i++) {
            permutation("", numbers, visited, i+1);
        }

        answer = count;

        return answer;
    }

    public static void permutation(String currentString, String numbers, boolean[] visited, int range) {
        if(currentString.length() == range) {
            System.out.println(currentString);
            if(isPrime(Integer.parseInt(currentString)) && hashMap.getOrDefault(Integer.parseInt(currentString), true)) {
                count += 1;
                hashMap.put(Integer.parseInt(currentString), false);
            }
            return;
        }

        for(int i=0;i<numbers.length();i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation(currentString + numbers.charAt(i), numbers, visited, range);
                visited[i] = false;
            }
        }
    }

    // 에라토스테네스의 체
    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        } else{
            for(int i=2;i<n;i++){
                if(n%i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
