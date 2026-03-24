package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 이 도시에 있는 치킨집은 모두 같은 프랜차이즈이다. 프렌차이즈 본사에서는 수익을 증가시키기 위해 일부 치킨집을 폐업시키려고 한다. 오랜 연구 끝에 이 도시에서 가장 수익을 많이 낼 수 있는  치킨집의 개수는 최대 M개라는 사실을 알아내었다.
 *
 * 도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.
 *
 * 둘째 줄부터 N개의 줄에는 도시의 정보가 주어진다.
 *
 * 도시의 정보는 0, 1, 2로 이루어져 있고, 0은 빈 칸, 1은 집, 2는 치킨집을 의미한다. 집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.
 *
 * 출력
 * 첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.
 */

//5 3
//0 0 1 0 0
//0 0 2 0 1
//0 1 2 0 0
//0 0 1 0 0
//0 0 0 0 2
//
//5
public class 백트래킹_g5_15686 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M;
    public static int[] result;
    public static List<Model> chickens = new ArrayList<>();
    public static List<Model> houses = new ArrayList<>();
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=N;j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input == 1) {
                    houses.add(new Model(i, j));
                } else if(input == 2) {
                    chickens.add(new Model(i, j));
                }
            }
        }

        result = new int[M];

        combination(0, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void combination(int start, int depth) throws IOException {
        if(M == depth) {
            int total = 0;
            for(int i=0;i<houses.size();i++) {
                Model house = houses.get(i);
                int min = Integer.MAX_VALUE;
                for(int j=0;j<result.length;j++) {
                    Model chicken = chickens.get(result[j]);
                    int dist = Math.abs(house.y - chicken.y) + Math.abs(house.x - chicken.x);
                    min = Math.min(min, dist);
                }
                total += min;
            }
            answer = Math.min(answer, total);
            return;
        }

        for(int i=start;i<chickens.size();i++) {
            result[depth] = i;
            combination(i + 1, depth + 1);
        }
    }

    public static class Model {
        int y, x;

        Model(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
