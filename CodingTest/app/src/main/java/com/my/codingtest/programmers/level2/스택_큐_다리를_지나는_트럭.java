package com.my.codingtest.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 스택_큐_다리를_지나는_트럭 {

    public static void main(String[] args) {
        int bridgeLength1 = 2;
        int weight1 = 10;
        int[] truckWeights1 = {7,4,5,6};

        int bridgeLength2 = 100;
        int weight2 = 100;
        int[] truckWeights2 = {10};

        int bridgeLength3 = 100;
        int weight3 = 100;
        int[] truckWeights3 = {10,10,10,10,10,10,10,10,10,10};


        System.out.println(solution(bridgeLength1, weight1, truckWeights1) + "");
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // bridge_length 올라갈 수 있는 최대 수
        // weight 견딜 수 있는 무게
        // truck_weights 대기 트럭

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> bridgeQueue = new LinkedList<>();
        int currentWeight = 0;

        for(int i=0;i<truck_weights.length;i++) {
            queue.add(truck_weights[i]);
        }

        for(int i=0;i<truck_weights.length;i++) {
            int car = truck_weights[i];
            // 칸을 한 칸씩 이동 할 때 마다 answer + 1
            while (true) {
                if(bridgeQueue.isEmpty()) {
                    bridgeQueue.add(car);
                    currentWeight += car;
                    answer++;
                    break;
                } else if(bridgeQueue.size() == bridge_length) {
                    int out = bridgeQueue.poll();
                    currentWeight -= out;
                } else if(weight >= (car + currentWeight)) {
                    bridgeQueue.add(car);
                    currentWeight += car;
                    answer++;
                    break;
                } else {
                    bridgeQueue.add(0);
                    answer++;
                }
            }
        }


        return answer + bridge_length; // 마지막 한 칸씩 이동하므로 brigde_length 더해주기
    }

}
