package com.my.codingtest.programmers.level2;

import java.util.*;

public class 비례식_시소_짝꿍 {

    public static void main(String[] args) {
        int[] weights1 = {100,180,360,100,270};
        // 4

        /**
         * 2 ≤ weights의 길이 ≤ 100,000
         * 100 ≤ weights[i] ≤ 1,000
         * 몸무게 단위는 N(뉴턴)으로 주어집니다.
         * 몸무게는 모두 정수입니다.
         *
         * {100, 100} 은 서로 같은 거리에 마주보고 앉으면 균형을 이룹니다.
         * {180, 360} 은 각각 4(m), 2(m) 거리에 마주보고 앉으면 균형을 이룹니다.
         * {180, 270} 은 각각 3(m), 2(m) 거리에 마주보고 앉으면 균형을 이룹니다.
         * {270, 360} 은 각각 4(m), 3(m) 거리에 마주보고 앉으면 균형을 이룹니다.
         * */

        System.out.println(solution(weights1));
    }

    public static ArrayList<Integer> list = new ArrayList<>();
    public static long solution(int[] weights) {
        long answer = 0;

        HashMap<Double, Integer> hashMap = new HashMap();

        Arrays.sort(weights);

        for(int i=0;i<weights.length;i++) {
            double a = (weights[i]*1.0) / 1.0; // 1:1
            double b = (weights[i]*2.0) / 3.0; // 2:3
            double c = (weights[i]*2.0) / 4.0; // 2:4
            double d = (weights[i]*3.0) / 4.0; // 3:4

            System.out.println(a +" / "+b+" / "+c+" / "+d);

            if(hashMap.containsKey(a)) {
                answer += hashMap.get(a);
                System.out.println("a");
            }
            if(hashMap.containsKey(b)) {
                answer += hashMap.get(b);
                System.out.println("b");
            }
            if(hashMap.containsKey(c)) {
                answer += hashMap.get(c);
                System.out.println("c");
            }
            if(hashMap.containsKey(d)) {
                answer += hashMap.get(d);
                System.out.println("d");
            }

            if(hashMap.containsKey((double) weights[i])) {
                hashMap.put((double) weights[i], hashMap.get((double) weights[i]) + 1);
            } else {
                hashMap.put((double) weights[i], 1);
            }

            list.add(weights[i]);
            System.out.println(Arrays.toString(list.toArray()));
        }

        return answer;
    }

//    public static void bfs(long x, long y, HashMap<String, Boolean> visitedMap) {
//        Queue<Pointer> queue = new LinkedList<>();
//
//        queue.add(new Pointer(x, y));
//
//        while (!queue.isEmpty()) {
//            Pointer pointer = queue.poll();
//
//            if(pointer.x == pointer.y) {
////                totalCount += 1;
//                return;
//            }
//
//            if(pointer.x * 2 == x * 2 && !visitedMap.containsKey(pointer.x * 2 + " / " + pointer.y)) {
//                queue.add(new Pointer(pointer.x * 2, pointer.y));
//                visitedMap.put(pointer.x * 2 + " / " + pointer.y, true);
//                visitedMap.put(pointer.y + " / " + pointer.x * 2, true);
//            }
//            if(pointer.x * 3 == x * 3 && !visitedMap.containsKey(pointer.x * 3 + " / " + pointer.y)) {
//                queue.add(new Pointer(pointer.x * 3, pointer.y));
//                visitedMap.put(pointer.x * 3 + " / " + pointer.y, true);
//                visitedMap.put(pointer.y + " / " + pointer.x * 3, true);
//            }
//            if(pointer.x * 4 == x * 4 && !visitedMap.containsKey(pointer.x * 4 + " / " + pointer.y)) {
//                queue.add(new Pointer(pointer.x * 4, pointer.y));
//                visitedMap.put(pointer.x * 4 + " / " + pointer.y, true);
//                visitedMap.put(pointer.y + " / " + pointer.x * 4, true);
//            }
//
//            if(pointer.y * 2 == y * 2 && !visitedMap.containsKey(pointer.x + " / " + pointer.y * 2)) {
//                queue.add(new Pointer(pointer.x, pointer.y * 2));
//                visitedMap.put(pointer.x + " / " + pointer.y * 2, true);
//                visitedMap.put(pointer.y * 2 + " / " + pointer.x, true);
//            }
//            if(pointer.y * 3 == y * 3 && !visitedMap.containsKey(pointer.x + " / " + pointer.y * 3) ) {
//                queue.add(new Pointer(pointer.x, pointer.y * 3));
//                visitedMap.put(pointer.x + " / " + pointer.y * 3, true);
//                visitedMap.put(pointer.y * 3 + " / " + pointer.x, true);
//            }
//            if(pointer.y * 4 == y * 4 && !visitedMap.containsKey(pointer.x + " / " + pointer.y * 4)) {
//                queue.add(new Pointer(pointer.x, pointer.y * 4));
//                visitedMap.put(pointer.x + " / " + pointer.y * 4, true);
//                visitedMap.put(pointer.y * 4 + " / " + pointer.x, true);
//            }
//
//        }
//    }
//
//    public static class Pointer {
//        long x;
//        long y;
//
//        Pointer(long x, long y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

}
