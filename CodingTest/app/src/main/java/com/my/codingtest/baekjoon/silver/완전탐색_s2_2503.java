package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_s2_2503 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        ArrayList<Model> list = new ArrayList<>();
        int answer = 0;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Model(
                    st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        for(int i=1;i<=9;i++) {
            for(int j=1;j<=9;j++) {
                for(int k=1;k<=9;k++) {
                    if(i == j || i == k || j == k) {
                        continue;
                    }

                    int[] current = {i, j, k};

                    boolean isValid = true;

                    for(int l=0;l<list.size();l++) {
                        Model model = list.get(l);
                        int[] input = {
                                Integer.parseInt(String.valueOf(model.number.charAt(0))),
                                Integer.parseInt(String.valueOf(model.number.charAt(1))),
                                Integer.parseInt(String.valueOf(model.number.charAt(2)))
                        };
                        int s = model.strike;
                        int b = model.ball;

                        int strike = 0;
                        int ball = 0;

                        // current 숫자와 input으로 얻은 숫자들을 비교하여
                        // 똑같은 strike와 ball이 나오는지 확인
                        for(int q=0;q<3;q++) {
                            for(int w=0;w<3;w++) {
                                if(current[q] == input[w]) {
                                    if(q == w) {
                                        strike += 1;
                                    } else {
                                        ball += 1;
                                    }
                                }
                            }
                        }

                        // strike와 ball이 모두 같지 않으면 예상값이 아니다.
                        if(strike == s && ball == b) {

                        } else {
                            isValid = false;
                            break;
                        }
                    }

                    if(isValid) {
                        answer += 1;
                    }
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Model {
        String number;
        int strike, ball;

        Model(String n, int s, int b) {
            number = n;
            strike = s;
            ball = b;
        }
    }
}
