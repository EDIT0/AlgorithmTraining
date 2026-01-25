package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 트리_s1_1991 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static String[][] tree;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        tree = new String[N][3];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String parentNode = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();

            tree[i][0] = parentNode;
            tree[i][1] = leftNode;
            tree[i][2] = rightNode;
        }

        preorder("A");
        bw.write("\n");
        inorder("A");
        bw.write("\n");
        postorder("A");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void preorder(String node) throws IOException {
        if(node.equals(".")) {
            return;
        }

        for(int i=0;i<tree.length;i++) {
            if(tree[i][0].equals(node)) {
                bw.write(tree[i][0]);
                preorder(tree[i][1]);
                preorder(tree[i][2]);
            }
        }
    }

    public static void inorder(String node) throws IOException {
        if(node.equals(".")) {
            return;
        }

        for(int i=0;i<tree.length;i++) {
            if(tree[i][0].equals(node)) {
                inorder(tree[i][1]);
                bw.write(tree[i][0]);
                inorder(tree[i][2]);
            }
        }
    }

    public static void postorder(String node) throws IOException {
        if(node.equals(".")) {
            return;
        }

        for(int i=0;i<tree.length;i++) {
            if(tree[i][0].equals(node)) {
                postorder(tree[i][1]);
                postorder(tree[i][2]);
                bw.write(tree[i][0]);
            }
        }
    }

}
