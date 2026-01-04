package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 구현_s3_1966 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken()); // 문서의 개수 (1 ≤ N ≤ 100)
            int M = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 (0 ≤ M < N)
            Queue<Model> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++) {
                int value = Integer.parseInt(st.nextToken());
                queue.add(new Model(j, value));
                pq.add(value);
            }

            int answer = 0;
            while (!queue.isEmpty()) {
                if(pq.isEmpty()) {
                    break;
                }

                int target = pq.poll();
                Model model = queue.poll();

                if(model.y == target) {
                    answer += 1;
                    if(model.x == M) {
                        break;
                    }
                } else {
                    pq.add(target);
                    queue.add(new Model(model.x, model.y));
                }
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static class Model {
        int x, y;

        Model(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
