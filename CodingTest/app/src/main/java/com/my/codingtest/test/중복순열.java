package com.my.codingtest.test;

/**
 * 순서가 있게 뽑는 것은 순열과 동일하지만 같은 원소를 중복해서 뽑을 수 있다.
 */
public class 중복순열 {
    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        int r = 3;
        permutation(arr, new int[r], 0, r);
    }

    public static void permutation(int[] arr, int[] out, int depth, int r){
        if(depth == r){
            for(int i=0;i<out.length;i++) {
                System.out.print(out[i] + ", ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<arr.length; i++) {
            out[depth] = arr[i];
            permutation(arr, out, depth+1, r);
        }
    }
}
