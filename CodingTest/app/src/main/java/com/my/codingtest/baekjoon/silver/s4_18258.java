package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_18258 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            LinkedList<Integer> queue = new LinkedList<>();

            StringTokenizer st;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if (command.equals("push")) {
                    push(queue, Integer.parseInt(st.nextToken()));
                } else if (command.equals("pop")) {
                    pop(bw, queue);
                } else if (command.equals("size")) {
                    size(bw, queue);
                } else if (command.equals("empty")) {
                    empty(bw, queue);
                } else if (command.equals("front")) {
                    front(bw, queue);
                } else if (command.equals("back")) {
                    back(bw, queue);
                }
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }

    public static void push(LinkedList queue, int X) {
        queue.add(X);
    }

    public static void pop(BufferedWriter bw, LinkedList queue) throws Exception {
        if (queue.isEmpty()) {
            bw.write("-1\n");
        } else {
            bw.write(queue.poll() + "\n");
        }
    }

    public static void size(BufferedWriter bw, LinkedList queue) throws Exception {
        bw.write(queue.size() + "\n");
    }

    public static void empty(BufferedWriter bw, LinkedList queue) throws Exception {
        if (queue.isEmpty()) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }
    }

    public static void front(BufferedWriter bw, LinkedList queue) throws Exception {
        if (queue.isEmpty()) {
            bw.write("-1\n");
        } else {
            bw.write(queue.peek() + "\n");
        }
    }

    public static void back(BufferedWriter bw, LinkedList queue) throws Exception {
        if (queue.isEmpty()) {
            bw.write("-1\n");
        } else {
            bw.write(queue.peekLast() + "\n");
        }
    }
}
