package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

// BFS
public class 구현_g3_16236 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N;
    public static int[][] board;
    public static Model babyShark;
    public static boolean[][] visited;

    public static int[] directionX = {1, 0, -1, 0};
    public static int[] directionY = {0, 1, 0, -1};

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9) {
                    babyShark = new Model(i, j, 2, 0, 0);
                }
            }
        }

        /**
         * N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.
         *
         * 아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
         *
         * 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
         *
         * 아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.
         *
         * 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
         * 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
         * 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
         * 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
         * 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
         * 아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.
         *
         * 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
         *
         * 공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.
         */


        while (true) {
            visited = new boolean[N][N];
            Queue<Model> queue = new LinkedList<>();
            queue.offer(babyShark);
            visited[babyShark.x][babyShark.y] = true;

            int minTime = Integer.MAX_VALUE;
            boolean isFindFish = false;
            ArrayList<Model> eatableFish = new ArrayList<>();

            // 현재에서 먹을 수 있는 물고기 후보 찾기
            while (!queue.isEmpty()) {
                Model poll = queue.poll();

                int pollX = poll.x;
                int pollY = poll.y;

                for(int i=0;i<4;i++) {
                    int dX = directionX[i];
                    int dY = directionY[i];

                    int newX = pollX + dX;
                    int newY = pollY + dY;

                    if(newX >= 0 && newX < N && newY >= 0 && newY < N && !visited[newX][newY]) {
                        int targetN = board[newX][newY];

                        // 아기상어보다 큰 물고기는 지나갈 수 없음
                        if(targetN > poll.size) {
                            continue;
                        }
                        visited[newX][newY] = true;

                        int newTime = poll.time + 1;

                        // 0이 아니고 먹을 수 있는 물고기
                        if(targetN < poll.size && targetN != 0) {
                            if(!isFindFish || newTime < minTime) {
                                minTime = newTime;
                                eatableFish.clear();
                                eatableFish.add(new Model(newX, newY, poll.size, poll.eatingCount, newTime));
                                isFindFish = true;
                            } else if(newTime == minTime) {
                                eatableFish.add(new Model(newX, newY, poll.size, poll.eatingCount, newTime));
                            }
                        } else {
                            // 0이거나 아기상어랑 같은 크기 물고기
                            queue.add(new Model(newX, newY, poll.size, poll.eatingCount, newTime));
                        }
                    }
                }
            }

            // 먹을 수 있는 물고기가 없으면 종료
            if(!isFindFish) {
                break;
            }

            // 후보 물고기들 정렬
            eatableFish.sort((a, b) -> {
                if (a.time == b.time) {
                    if (a.x == b.x) {
                        if (a.y < b.y) {
                            return -1; // 그대로
                        }
                        else if (a.y > b.y) {
                            return 1; // b가 작으니까 변경
                        }
                        else {
                            return 0;
                        }
                    }
                    if (a.x < b.x) {
                        return -1; // a가 작으니까 그대로
                    }
                    else if (a.x > b.x) {
                        return 1; // b가 작으니까 변경
                    }
                    else {
                        return 0;
                    }
                }
                if (a.time < b.time) {
                    return -1; // 가까운 거리 우선
                }
                else if (a.time > b.time) {
                    return 1; // 거리가 멀면 변경
                }
                else {
                    return 0;
                }
            });

            // 가장 우선순위 높은 물고기 선택
            Model target = eatableFish.get(0);

            // 시간 누적
            answer += target.time;

            // 선택된 곳으로 아기상어 이동, 원래 자리 0으로 초기화, 정보 초기화
            board[babyShark.x][babyShark.y] = 0;
            babyShark.x = target.x;
            babyShark.y = target.y;
            babyShark.time = 0;
            board[target.x][target.y] = 0;

            // 먹은 횟수/크기 갱신
            babyShark.eatingCount++;
            if (babyShark.eatingCount == babyShark.size) {
                babyShark.size++;
                babyShark.eatingCount = 0;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

    public static class Model {
        int x, y, size, eatingCount, time;

        Model(int x, int y, int size, int eatingCount, int time) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eatingCount = eatingCount;
            this.time = time;
        }
    }
}
