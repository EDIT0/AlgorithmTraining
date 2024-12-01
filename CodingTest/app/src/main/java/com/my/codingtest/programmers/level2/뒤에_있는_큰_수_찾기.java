package com.my.codingtest.programmers.level2;

import java.util.*;

public class 뒤에_있는_큰_수_찾기 {

    public static void main(String[] args) {
        int[] numbers1 = {2, 3, 3, 5};
        // [3, 5, 5, -1]
        int[] numbers2 = {9, 1, 5, 3, 6, 2};
        // [-1, 5, 6, 6, -1, -1]

        int[] numbers3 = {9, 1, 5, 3, 6, 7};
        // [-1, 5, 6, 6, 7, -1]

        int[] numbers4 = {9, 1, 5, 5, 6, 7};
        // [-1, 5, 6, 6, 7, -1]

        System.out.println(Arrays.toString(solution(numbers1)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};

        answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i=1;i<numbers.length;i++) {
            System.out.println(stack.peek() + " / " + numbers[stack.peek()] + " / " + numbers[i]);

            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                System.out.println("In while " + stack.peek() + " / " + numbers[stack.peek()] + " / " + numbers[i]);
                answer[stack.pop()] = numbers[i];
            }
            System.out.println(i + " 넣기 \n");

            stack.push(i);
        }
        // 모든 index를 탐색 후 뒤에 있는 큰 수가 없는 경우 -1
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        // 방법 2. 시간 초과
//        Stack<Integer> stack = new Stack<>();
//
//        for(int i=0;i<numbers.length;i++){
//            stack.push(numbers[i]);
//        }
//
//        int index = numbers.length-1;
//        answer[index] = -1;
//        index -= 1;
//        ArrayList<Integer> maxList = new ArrayList<>();
//        maxList.add(numbers[index+1]);
//        while (!stack.isEmpty() && index >= 0) {
//            int popNum = stack.pop();
//            if(numbers[index] < popNum) {
//                answer[index] = popNum;
//                maxList.add(answer[index]);
//                index -= 1;
//            } else {
//                for(int i=maxList.size()-1;i>=0;i--) {
//                    System.out.println(numbers[index] + " / " + maxList.get(i));
//                    if(numbers[index] < maxList.get(i)) {
//                        answer[index] = maxList.get(i);
//                        break;
//                    } else {
//                        answer[index] = -1;
//                    }
//                }
//                System.out.println();
//                maxList.add(answer[index]);
//                index -= 1;
//            }
//        }

        // 방법 1. 시간 초과
//        for(int i=0;i<numbers.length;i++) {
//            int targetNumber = numbers[i];
//            int index = i+1;
//            while (index < numbers.length) {
//                int nextNumber = numbers[index];
//                if(targetNumber >= nextNumber) {
//                    index += 1;
//                } else {
//                    answer[i] = nextNumber;
//                    System.out.println(nextNumber + " 넣기");
//                    break;
//                }
//            }
//            if(answer[i] == 0) {
//                answer[i] = -1;
//                System.out.println("-1 넣기!");
//            }
//        }

        return answer;
    }

}
