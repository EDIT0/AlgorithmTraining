package com.my.codingtest.test;

import java.util.Collections;
import java.util.PriorityQueue;

public class 우선순위_큐 {

    public static void main(String[] args) {
        // 기본형: 우선순위가 낮은 숫자가 먼저 나옴 (작은 숫자)
        PriorityQueue<Integer> lowNumberQueue = new PriorityQueue<>();

        // 우선순위가 높은 숫자가 먼저 나옴 (큰 숫자)
        PriorityQueue<Integer> highNumberQueue = new PriorityQueue<>(Collections.reverseOrder());

        // 참고 https://kbj96.tistory.com/49
//        add() : 우선순위 큐에 원소를 추가. 큐가 꽉 찬 경우 에러 발생
//        offer() : 우선순위 큐에 원소를 추가. 값 추가 실패 시 false를 반환
//        poll() : 우선순위 큐에서 첫 번째 값을 반환하고 제거, 비어있으면 null 반환
//        remove() : 우선순위 큐에서 첫 번째 값을 반환하고 제거, 비어있으면 에러 발생
//        isEmpty() : 우선순위 큐에서 첫 번째 값을 반환하고 제거, 비어있으면 에러 발생
//        clear() : 우선순위 큐를 초기화
//        size() : 우선순위 큐에 포함되어 있는 원소의 수를 반환


    }

}
