package com.my.codingtest.programmers.level1;

public class 나머지가_1이_되는_수_찾기 {

    public static void main(String[] args) {
        int n1 = 10;

        int n2 = 12;

        System.out.println(solution(n2) + "");
    }

    public static int solution(int n) {
        int answer = 0;

        n = n-1;
        int x = 2;
        while (true) {
            if(n%x == 0) {
                answer = x;
                break;
            }
            x += 1;
        }

        return answer;
    }

}
