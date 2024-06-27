package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s2_18870 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            long[] arr = new long[N]; // 원 배열
            long[] sortArr = new long[N]; // 정렬할 배열
            HashMap<Long, Long> longHashMap = new HashMap(); // 중복값 처리를 위한 해시맵

            for(int i=0;i<N;i++) {
                long input = Long.parseLong(st.nextToken());
                arr[i] = input;
                sortArr[i] = input;
            }

            Arrays.sort(sortArr);

            int idx = 0; // 갯수
            // key: (-10, -5, 0, 3, 6) / value: (0, 1, 2, 3, 4)
            for(int i=0;i<sortArr.length;i++) {
                if(!longHashMap.containsKey(sortArr[i])) {
                    longHashMap.put(sortArr[i], (long) idx);
                    idx++;
                }
            }

            for(int i=0;i<arr.length;i++) {
                arr[i] = longHashMap.get(arr[i]); // 각 배열 값이 key이므로 그에 맞는 value를 넣어준다.
                bw.write(arr[i] + " ");
            }

            // 시간 초과
//            ArrayList<Long> longList = new ArrayList<>();
//            long[] resultArr = new long[N];
//            for(int i=0;i<N;i++) {
//                long count = 0L;
//                long num = arr[i];
//
//                for(int j=0;j<N;j++) {
//                    if(num > arr[j] && !longList.contains(arr[j])) { // 각 비교하는 차수마다 리스트에 있는 숫자하고는 비교하지 않도록 하기 위함.
//                        count++;
//                    }
//                    longList.add(arr[j]);
//                }
//                resultArr[i] = count;
//                longList.clear(); // 한 차수가 끝나면 초기화
//            }
//
//            for(int i=0;i<N;i++) {
//                bw.write(resultArr[i] + " ");
//            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
