package com.my.codingtest.programmers.level2;

import java.util.*;

public class 스택_택배상자 {

    public static void main(String[] args) {
        int[] order1 = {4, 3, 1, 2, 5};
        // 2

        int[] order2 = {5, 4, 3, 2, 1};
        // 5

        int[] order3 = {3, 5, 4, 2, 1};
        // 5

        System.out.println(solution(order1));
    }

    public static int solution(int[] order) {
        int answer = 0;

        Stack<Integer> subContainerStack = new Stack<>();

        int currentOrder = 0;
        boolean key;
        for(int i=1;i<=order.length;i++) {
            key = false;
            if(order[currentOrder] == i) {
                answer += 1;
                currentOrder += 1;
                key = true;
            }

            while (!subContainerStack.isEmpty()) {
                if(subContainerStack.peek() == order[currentOrder]) {
                    subContainerStack.pop();
                    answer += 1;
                    currentOrder += 1;
                } else {
                    break;
                }
            }
            if(!key) {
                subContainerStack.push(i);
            }
        }

        return answer;
    }

}
