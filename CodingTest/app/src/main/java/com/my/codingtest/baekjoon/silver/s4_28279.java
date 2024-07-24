package com.my.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class s4_28279 {

    public static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                if(x == 1 || x == 2) {
                    int y = Integer.parseInt(st.nextToken());
                    switch (x) {
                        case 1: {
                            putFront(y);
                            break;
                        }
                        case 2: {
                            putRear(y);
                            break;
                        }
                        default: {

                        }
                    }
                } else {
                    switch (x) {
                        case 3: {
                            bw.write(popFront() + "\n");
                            break;
                        }
                        case 4: {
                            bw.write(popRear() + "\n");
                            break;
                        }
                        case 5: {
                            bw.write(size() + "\n");
                            break;
                        }
                        case 6: {
                            bw.write(isEmpty() + "\n");
                            break;
                        }
                        case 7: {
                            bw.write(peekFront() + "\n");
                            break;
                        }
                        case 8: {
                            bw.write(peekRear() + "\n");
                            break;
                        }
                    }
                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    public static void putFront(int n) {
        deque.addFirst(n);
    }

    public static void putRear(int n) {
        deque.addLast(n);
    }

    public static int popFront() {
        if(!deque.isEmpty()) {
            return deque.pollFirst();
        } else {
            return -1;
        }
    }

    public static int popRear() {
        if(!deque.isEmpty()) {
            return deque.pollLast();
        } else {
            return -1;
        }
    }

    public static int size() {
        return deque.size();
    }

    public static int isEmpty() {
        if(deque.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int peekFront() {
        if(!deque.isEmpty()) {
            return deque.getFirst();
        } else {
            return -1;
        }
    }

    public static int peekRear() {
        if(!deque.isEmpty()) {
            return deque.getLast();
        } else {
            return -1;
        }
    }
}
