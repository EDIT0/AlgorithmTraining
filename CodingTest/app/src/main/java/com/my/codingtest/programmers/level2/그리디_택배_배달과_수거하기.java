package com.my.codingtest.programmers.level2;

public class 그리디_택배_배달과_수거하기 {

    public static void main(String[] args) {
        int cap1 = 4;
        int n1 = 5;
        int[] deliveries1 = {1, 0, 3, 1, 2};
        int[] pickups1 =    {0, 3, 0, 4, 0};
        // 16

        int cap2 = 2;
        int n2 = 7;
        int[] deliveries2 = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups2 =    {0, 2, 0, 1, 0, 2, 0};
        // 30

        System.out.println(solution(cap1, n1, deliveries1, pickups1));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int deliveryLeft = 0; // 배달해야 할 잔여 물량
        int pickupLeft = 0; // 수거해야 할 잔여 물량

        for (int i=n-1;i>=0;i--) {
            deliveryLeft += deliveries[i];
            pickupLeft += pickups[i];

            System.out.println("시작 " + i + " / " + deliveryLeft + " / " + pickupLeft);

            // 배달과 수거 중 남아있는 작업이 있는 경우 거리 추가
            while (deliveryLeft > 0 || pickupLeft > 0) {
                answer += (i+1)*2L; // 왕복 거리
                deliveryLeft -= cap; // 배달 가능한 만큼 배달
                pickupLeft -= cap; // 수거 가능한 만큼 수거
                System.out.println("현 상태 " + deliveryLeft + " / " + pickupLeft);
            }
            System.out.println();
        }

        return answer;
    }
    
}
