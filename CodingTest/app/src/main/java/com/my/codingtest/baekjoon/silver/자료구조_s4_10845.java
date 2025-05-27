package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s4_10845 {

    public static Queue<Integer> queue = new LinkedList<>();
    public static int back;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String order = st.nextToken();

                orderFunc(order, st, bw);

            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void orderFunc(String o, StringTokenizer st, BufferedWriter bw) throws Exception {
        switch (o) {
            case "push": {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
                back = num;
                break;
            }
            case "pop": {
                if(queue.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    int pop = queue.poll();
                    bw.write(pop + "\n");
                }
                break;
            }
            case "size": {
                if(queue.isEmpty()) {
                    bw.write("0" + "\n");
                } else {
                    bw.write(queue.size() + "\n");
                }
                break;
            }
            case "empty": {
                if(queue.isEmpty()) {
                    bw.write("1" + "\n");
                } else {
                    bw.write("0" + "\n");
                }
                break;
            }
            case "front": {
                if(queue.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    int num = queue.peek();
                    bw.write(num + "\n");
                }
                break;
            }
            case "back": {
                if(queue.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(back + "\n");
                }
                break;
            }
        }
    }
}
