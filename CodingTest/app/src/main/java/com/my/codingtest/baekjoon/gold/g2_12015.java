package com.my.codingtest.baekjoon.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class g2_12015 {
    public static void main(String[] args) {

        // 100,000,000

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> result = new ArrayList<>();

            result.add(A[0]);

            // result 리스트를 순서 보장 하면서 이분탐색을 돌린다.
            for(int i=1;i<A.length;i++) {
                if(result.get(result.size() - 1) < A[i]) { // result 리스트의 마지막 값보다 A[i] 값이 크면 result 리스트의 마지막에 A[i]를 추가만 한다.
                    result.add(A[i]);
                } else {
                    result.set(binary1(A[i], result), A[i]);
                }
            }

            bw.write(result.size() + "");
//            for(int i=0;i<result.size();i++) {
//                bw.write(result.get(i) + " ");
//            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }

    }


    public static int binary1(int key, ArrayList<Integer> arrList) {
        int start = 0;
        int end = arrList.size() - 1;
        int mid;

        int result = -1;
        while (start <= end) {
            mid = (start + end) / 2;

            if(arrList.get(mid) == key) {
                // 값이 같으면 mid 자리에 값을 교체해도되고 안해도된다.
                return mid;
            } else if(arrList.get(mid) < key) {
                // arrList.get[mid]보다 key가 크다는 것은 key 값이 더 뒤에 위치하여야 한다는 것이기 때문에 result에 mid를 저장하지 않는다.
                start = mid + 1;
            } else if(arrList.get(mid) > key) {
                result = mid; // arrList.get[mid]보다 key가 작기 때문에 현재 mid의 위치에 result가 들어갈 가능성이 있다.
                end = mid - 1;
            }
        }

        return result;
    }
}
