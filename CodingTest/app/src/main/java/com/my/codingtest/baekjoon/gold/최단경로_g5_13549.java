package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

// 0-1 BFS
public class 최단경로_g5_13549 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, K;
    public static int[] dist;
    public static int MAX = 100001;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[MAX];
        Arrays.fill(dist, MAX);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(N);
        dist[N] = 0;

        while (!deque.isEmpty()) {
//            System.out.print("현재 deque: ");
//            for (Integer element : deque) {
//                System.out.print(element + " ");
//            }
//            System.out.println();

            int poll = deque.poll();

            if(poll == K) {
                bw.write(dist[poll] + "");
                break;
            }

            int jump = poll * 2;
            if(jump < MAX && dist[jump] > dist[poll]) {
                dist[jump] = dist[poll];
                deque.addFirst(jump);
            }
            int back = poll - 1;
            if(back >= 0 && dist[back] > dist[poll] + 1) {
                dist[back] = dist[poll] + 1;
                deque.addLast(back);
            }
            int front = poll + 1;
            if(front < MAX && dist[front] > dist[poll] + 1) {
                dist[front] = dist[poll] + 1;
                deque.addLast(front);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
