package com.my.codingtest.test;

import java.util.ArrayList;
import java.util.Arrays;

public class 순열 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int r = 2;
        permutation(arr, new int[r], new boolean[arr.length], 0, r);

        System.out.println("n번째 순열 찾기 " + Arrays.toString(n_번째_순열_찾기(3, 6)));
    }

    public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r){
        if(depth == r){
            for(int i=0;i<out.length;i++) {
                System.out.print(out[i] + ", ");
            }
            System.out.println();
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }

    public static int[] n_번째_순열_찾기(int length, int k) {
        int[] answer;

        answer = new int[length];
        ArrayList<Integer> list = new ArrayList<>();

        //총 경우의 수 n!
        int total = 1;
        for(int i=1;i<=length;i++) {
            list.add(i);
            total *= i;
        }

        //배열의 인덱스는 0부터 시작하여 찾아야될 번호를 -1
        k--;

        int idx = 0;
        while(idx < length) {
            //전체 경우의 수 / 숫자의 갯수
            total /= length - idx;
            System.out.println(total + " / " +  k + " / " + idx);
            //해당 인덱스의 값의 숫자 가져오기
            answer[idx++] = list.remove(k/total);
            //다음 찾아야될 번호
            k %= total;
        }

        return answer;
    }
}
