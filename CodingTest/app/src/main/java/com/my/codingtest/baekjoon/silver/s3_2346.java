package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s3_2346 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Model[] modelArr = new Model[N+1];

            for(int i=1;i<=N;i++) {
                modelArr[i] = new Model(i, Integer.parseInt(st.nextToken()));
            }

            ArrayList<Integer> result = new ArrayList<>();

            int number = 0; // 일반 숫자 넣을 곳
            int innerNumber = 0; // 일반 숫자의 짝 수 넣을 곳

            int index = 1; // 현재 가리키는 위치
            int count = 0; // 몇 번 세었는지 확인

            while (true) {
                number = modelArr[index].number; // index는 1부터 시작
                innerNumber = modelArr[index].innerNumber; // 1의 짝 수

                if(number == 0) { // 숫자가 0이면 이미 터진 풍선
                    if(innerNumber > 0) { // 짝 수가 양수면 index +1
                        index++;
                        if(index > N) {
                            index = 1;
                        }
                    } else { // 짝 수가 음수면 index -1
                        index--;
                        if(index < 1) {
                            index = N;
                        }
                    }
                } else { // 숫자가 0이 아니라면 터지지 않은 풍선
                    result.add(number); // 현재 숫자를 결과 리스트에 추가
                    modelArr[index].number = 0; // 현재 숫자의 자리를 0으로 만들어서 풍선 터뜨리기

                    if(N == result.size()) { // result의 갯수가 N과 같아지면 모든 풍선이 다 터진 것이므로 break
                        break;
                    }

                    if(innerNumber < 0) { // -일 경우
                        while (true) {
                            if(modelArr[index].number != 0) { // 0이 아니면 터지지 않은 풍선
                                count--;
                                if(count == innerNumber) { // count와 innerNumber가 같다는 것은 터져야하는 순서라는 것
                                    break;
                                } else {
                                    index--; // 터지지 않은 풍선이지만 원하는 순번의 풍선이 아니므로 index -1
                                }
                            } else { // 0이면 count를 세지 않고 index만 -1
                                index--;
                            }
                            if(index < 1) {
                                index = N;
                            }
                        }
                    } else { // +일 경우
                        while (true) {
                            if(modelArr[index].number != 0) { // 0이 아니면 터지지 않은 풍선
                                count++;
                                if(count == innerNumber) { // count와 innerNumber가 같다는 것은 터져야하는 순서라는 것
                                    break;
                                } else {
                                    index++; // 터지지 않은 풍선이지만 원하는 순번의 풍선이 아니므로 index +1
                                }
                            } else { // 0이면 count를 세지 않고 index만 +1
                                index++;
                            }
                            if(index > N) {
                                index = 1;
                            }
                        }
                    }
                }

                count = 0; // 하나의 number와 innerNumber에 대해 찾았으면 count는 0으로 초기화
            }

            for(int i=0;i<result.size();i++) {
                bw.write(result.get(i) + " ");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}

class Model {
    int number;
    int innerNumber;
    Model(int number, int innerNumber) {
        this.number = number;
        this.innerNumber = innerNumber;
    }
}
