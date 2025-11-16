package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 그리디_g4_1339 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine();
        }

//        Arrays.sort(arr, (o1, o2) -> {
//            if(o1.length() > o2.length()) {
//                return -1;
//            } else if(o1.length() < o2.length()) {
//                return 1;
//            } else {
//                return 0;
//            }
//        });

//        for(int i=0;i<arr.length;i++) {
//            System.out.println(arr[i]);
//        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> keyMap = new HashMap<>();

        // 가치 부여
        for(int i=0;i<arr.length;i++) {
            int length = arr[i].length();
            for(int j=0;j<length;j++) {
                int value = (int) Math.pow(10, length - j - 1);
                hashMap.put(arr[i].charAt(j), hashMap.getOrDefault(arr[i].charAt(j), 0) + value);
            }
        }

//        for(Map.Entry entry : hashMap.entrySet()) {
//            System.out.println(entry.getKey() + " / " + entry.getValue());
//        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hashMap.entrySet());

        // value 내림차순으로 정렬
        Collections.sort(list, (o1, o2) -> {
            if(o1.getValue() < o2.getValue()) {
                return 1;
            } else if(o1.getValue() > o2.getValue()) {
                return -1;
            } else {
                return 0;
            }
        });

        // 알파벳에 숫자 부여
        int currentMax = 9;
        for(int i=0;i<list.size();i++) {
            if(!keyMap.containsKey(list.get(i).getKey())) {
                keyMap.put(list.get(i).getKey(), currentMax);
                currentMax -= 1;
            }
        }

//        for(Map.Entry entry : keyMap.entrySet()) {
//            System.out.println(entry.getKey() + " / " + entry.getValue());
//        }

        // 계산
        int sum = 0;
        for(int i=0;i<arr.length;i++) {
            int length = arr[i].length();
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<length;j++) {
                sb.append(keyMap.get(arr[i].charAt(j)));
            }
            sum += Integer.parseInt(sb.toString());
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
