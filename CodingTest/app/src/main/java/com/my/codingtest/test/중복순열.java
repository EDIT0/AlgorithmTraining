package com.my.codingtest.test;

/**
 * 순서가 있게 뽑는 것은 순열과 동일하지만 같은 원소를 중복해서 뽑을 수 있다.
 */
public class 중복순열 {

    public static int[] arr = {1, 2, 3};
    public static int r = 3;
    public static int[] result = new int[r];

    public static void main(String[] args){
        permutation(0);
    }

    public static void permutation(int depth){
        if(depth == r){
            for(int i=0;i<result.length;i++) {
                System.out.print(result[i] + ", ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<arr.length; i++) {
            result[depth] = arr[i];
            permutation(depth+1);
        }
    }
}
