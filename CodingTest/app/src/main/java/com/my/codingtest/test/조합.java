package com.my.codingtest.test;

public class 조합 {

    public static int[] arr = {1, 2, 3};
    public static int r = 2;
    public static boolean[] visited = new boolean[arr.length];

    public static void main(String[] args){
        combination(0, 0);
    }

    public static void combination(int start, int depth){
        if(depth == r){
            for(int i=0; i<arr.length; i++){
                if(visited[i]) {
                    System.out.print(arr[i] + ", ");
                }
            }
            System.out.println();
            return;
        }
        for(int i=start; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}
