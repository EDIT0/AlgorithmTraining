package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s1_1991 {

    public static Map<String, Node> map = new HashMap<>();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;


            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                Node node = new Node();
                node.root = st.nextToken();
                node.left = st.nextToken();
                node.right = st.nextToken();

                map.put(node.root, node);
            }

            preOrder("A");
            bw.write("\n");
            inOrder("A");
            bw.write("\n");
            postOrder("A");


            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void preOrder(String node) throws Exception {
        if(node.equals(".")) {
            return;
        }
        bw.write(node);
        preOrder(map.get(node).left);
        preOrder(map.get(node).right);
    }

    public static void inOrder(String node) throws Exception {
        if(node.equals(".")) {
            return;
        }
        inOrder(map.get(node).left);
        bw.write(node);
        inOrder(map.get(node).right);
    }

    public static void postOrder(String node) throws Exception {
        if(node.equals(".")) {
            return;
        }
        postOrder(map.get(node).left);
        postOrder(map.get(node).right);
        bw.write(node);
    }

    public static class Node {
        String root;
        String left;
        String right;

        Node(){}

        Node(String root, String left, String right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }
}
