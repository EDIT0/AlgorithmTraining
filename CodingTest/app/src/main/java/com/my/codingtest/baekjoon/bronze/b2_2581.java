package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b2_2581 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int M = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            int firstNum = -1;
            int totalSum = 0;

            for(int i=M;i<=N;i++) {
                int sum = 0;

                // 소수 찾기 (sum이 1이면 소수)
                for(int j=0;j<i-1;j++) {
                    int k = i % (j+1);
                    if(k == 0) {
                        sum += (j+1);
                    }
                }

                if(sum == 1) { // sum이 1보다 크면 소수가 아니다.
                    if(firstNum == -1) {
                        firstNum = i;
                    }
                    totalSum += i;
                }
            }

            if(firstNum == -1) { // 가장 첫번재 숫자가 -1이면 소수가 없다는 것 이므로
                bw.write("-1");
            } else {
                bw.write("" + totalSum + "\n" + firstNum);
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }


    // 에라토스테네스의 체
    public static boolean isPrime(int n){ // 시간복잡도 O(N)
        if(n<2){
            return false; // 1은 소수가 아니기에 false
        }else{
            for(int i = 2; i < n; i++){
                if(n % i == 0) return false; // 나머지연산을 했을 때 0이 나오면 소수가 아니므로 false
            }
            return true; // 위의 case
        }
    }
}
