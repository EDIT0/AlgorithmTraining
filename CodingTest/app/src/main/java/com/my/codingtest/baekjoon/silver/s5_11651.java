package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s5_11651 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    /**
                     * 만약 e1[0]이 e2[0]보다 작다면 (e1[0] - e2[0] < 0), 음수를 반환합니다. 이는 e1이 e2보다 앞에 와야 함을 의미합니다.
                     * 만약 e1[0]이 e2[0]보다 크다면 (e1[0] - e2[0] > 0), 양수를 반환합니다. 이는 e1이 e2보다 뒤에 와야 함을 의미합니다.
                     * 만약 e1[0]이 e2[0]과 같다면 (e1[0] - e2[0] == 0), 두 번째 원소 e1[1]과 e2[1]을 비교합니다. e1[1] - e2[1]의 결과가 음수면 e1이 e2보다 앞에, 양수면 e1이 e2보다 뒤에 위치하게 됩니다.
                     * */
                    if (o1[1] != o2[1]) { // 각 객체의 1번째 수 비교
                        return o1[1] - o2[1]; // 각 1번째 수가 같지 않으면 1번째로 수 비교
                    } else {
                        return o1[0] - o2[0]; // 각 1번째 수가 같으면 0번째 수로 비교
                    }
                }
            });

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(arr[i][0] + " " + arr[i][1] + "\n");
            }

            bw.write(sb + "");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }
}
