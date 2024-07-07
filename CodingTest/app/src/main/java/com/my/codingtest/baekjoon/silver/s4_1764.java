package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_1764 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] arrN = new String[N];
            for(int i=0;i<N;i++) {
                arrN[i] = br.readLine();
            }

            String[] arrM = new String[M];
            for(int i=0;i<M;i++) {
                arrM[i] = br.readLine();
            }

            Arrays.sort(arrN);
            Arrays.sort(arrM);

            ArrayList<String> strList = new ArrayList<>();
            for(int i=0;i<M;i++) {
                if(binarySearch(arrM[i], arrN)) {
                    strList.add(arrM[i]);
                }
            }

            bw.write(strList.size() + "\n");
            for(int i=0;i<strList.size();i++) {
                bw.write(strList.get(i) + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    public static boolean binarySearch(String key, String[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if(arr[mid].equals(key)) {
                return true;
            } else if(stringComparison(key, arr[mid]) > 0) {
                start = mid + 1;
            } else if(stringComparison(key, arr[mid]) < 0) {
                end = mid - 1;
            }
        }


        return false;
    }

    public static int stringComparison(String a, String b) {
        if(a.compareTo(b) < 0) { // a가 b보다 앞에 있다면 음수
            return -1;
        } else if(a.compareTo(b) == 0) { // a가 b랑 같다면
            return 0;
        } else if(a.compareTo(b) > 0) { // a가 b보다 뒤에 있다면 양수
            return 1;
        }
        return Integer.MIN_VALUE;
    }
}
