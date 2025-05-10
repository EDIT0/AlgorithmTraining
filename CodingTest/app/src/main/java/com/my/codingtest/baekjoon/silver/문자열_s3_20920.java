package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 문자열_s3_20920 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<String> wordList = new ArrayList<>();
            for(int i=0;i<N;i++) {
                String word = br.readLine();
                if(word.length() >= M) {
                    wordList.add(word);
                }
            }

            wordList = check(wordList);

            for(String word : wordList) {
                bw.write(word + "\n");
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }

    public static ArrayList<String> check(ArrayList<String> list) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i=0;i<list.size();i++) {
            String word = list.get(i);
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        ArrayList<String> wordList = new ArrayList<>(hashMap.keySet());
        wordList.sort((a, b) -> {
            int d = hashMap.get(b) - hashMap.get(a); // 이게 +면 b가 a보다 빈도수가 더 많다는 것
            if(d > 0) {
                return d;
            } else if(d == 0) {
                // 빈도수가 같다면 단어 길이 비교
                if(a.length() > b.length()) {
                    return -1; // a가 앞으로 가야하므로 -
                } else if(a.length() == b.length()) {
                    // 단어 길이가 같다면 사전순 정렬
                    return a.compareTo(b);
                } else {
                    return 1; // a가 뒤로 가야하므로 +
                }
            } else {
                return d;
            }
        });

        return wordList;
    }

}
