package com.my.codingtest.test;

public class 중복조합 {

    public static int[] arr = {1, 2, 3};
    public static int r = 2;
    public static int[] result = new int[r];

    public static void main(String[] args){
        combination(0, 0);
    }

    public static void combination(int start, int depth){
        if(depth == r){
            for(int num : result) {
                System.out.print(num + ", ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<arr.length; i++){
            result[depth] = arr[i];
            combination(i, depth+1);
        }
    }

}
