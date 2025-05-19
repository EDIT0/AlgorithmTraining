package com.my.codingtest.baekjoon.silver;

import java.io.*;

public class 구현_s3_1913 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int findNumber = Integer.parseInt(br.readLine());
            int currentNumber = 1;
            int step = 1;
            int addPoint = 1;

            int nextAddPointA;
            int nextAddPointB;
            int nextAddPointC;
            int nextAddPointD;

            int[] directionX = {1, 0, -1, 0};
            int[] directionY = {0, 1, 0, -1};
            int d = 0;

            int[][] arr = new int[N][N];
            int x = N / 2;
            int y = N / 2;

            nextAddPointA = addPoint + 2 * step;
            nextAddPointB = addPoint + 4 * step;
            nextAddPointC = addPoint + 6 * step;
            nextAddPointD = addPoint + 8 * step;

            while (currentNumber <= N*N) {
                // 현재 레이어의 마지막 숫자에 도달하였을 경우
                if(addPoint == currentNumber) {

                    // 첫 단계(step==1)는 이미 중앙으로 잡혀져있으므로 건너뛰기
                    if(step != 1) {
                        d = 3;
                        x = x + directionX[d];
                        y = y + directionY[d];
                    } else {
                        d = 3;
                    }
//                    System.out.println("0. " + x + " / " + y + " = " + currentNumber);
                    arr[y][x] = currentNumber;

                    nextAddPointA = addPoint + 2 * step;
                    nextAddPointB = addPoint + 4 * step;
                    nextAddPointC = addPoint + 6 * step;
                    nextAddPointD = addPoint + 8 * step;

                    step += 1; // 마지막 addPoint에 닿으면 layer up
                    addPoint = nextAddPointD;

                    currentNumber += 1;
                    continue;
                }

                if(nextAddPointA > currentNumber) {
                    x = x + directionX[d];
                    y = y + directionY[d];
//                    System.out.println("1. " + x + " / " + y + " = " + currentNumber);
                    arr[y][x] = currentNumber;
                    d = 0;
                } else if(nextAddPointA == currentNumber) {
                    x = x + directionX[d];
                    y = y + directionY[d];
//                    System.out.println("2. " + x + " / " + y + " = " + currentNumber);
                    arr[y][x] = currentNumber;
                    d = 1;
                } else if(nextAddPointB > currentNumber) {
                    x = x + directionX[d];
                    y = y + directionY[d];
//                    System.out.println("3. " + x + " / " + y + " = " + currentNumber);
                    arr[y][x] = currentNumber;
                } else if(nextAddPointB == currentNumber) {
                    x = x + directionX[d];
                    y = y + directionY[d];
//                    System.out.println("4. " + x + " / " + y + " = " + currentNumber);
                    arr[y][x] = currentNumber;
                    d = 2;
                } else if(nextAddPointC > currentNumber) {
                    x = x + directionX[d];
                    y = y + directionY[d];
//                    System.out.println("5. " + x + " / " + y + " = " + currentNumber);
                    arr[y][x] = currentNumber;
                } else if(nextAddPointC == currentNumber) {
                    x = x + directionX[d];
                    y = y + directionY[d];
//                    System.out.println("6. " + x + " / " + y + " = " + currentNumber);
                    arr[y][x] = currentNumber;
                    d = 3;
                } else if(nextAddPointD > currentNumber) {
                    x = x + directionX[d];
                    y = y + directionY[d];
//                    System.out.println("7. " + x + " / " + y + " = " + currentNumber);
                    arr[y][x] = currentNumber;
                }

                currentNumber += 1;
            }

            int findX = 0;
            int findY = 0;

            for(int i=0;i<arr.length;i++) {
                for(int j=0;j<arr[0].length;j++) {
                    bw.write(arr[i][j] + " ");
                    if(findNumber == arr[i][j]) {
                        findY = i + 1;
                        findX = j + 1;
                    }
                }
                bw.write("\n");
            }

            bw.write(findY + " " + findX);

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
