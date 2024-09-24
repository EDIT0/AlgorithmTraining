package com.my.codingtest.programmers.level1;

import java.util.Stack;

public class 햄버거_만들기 {

    public static void main(String[] args) {
        int[] ingredient1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] ingredient2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};

        System.out.println(solution(ingredient2) + "");
    }

    public static int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<ingredient.length;i++) {
            stack.push(ingredient[i]);

            if(stack.size() >= 4) {
                boolean a = stack.get(stack.size()-4) == 1;
                boolean b = stack.get(stack.size()-3) == 2;
                boolean c = stack.get(stack.size()-2) == 3;
                boolean d = stack.get(stack.size()-1) == 1;

                if(a && b && c && d) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer += 1;
                }
            }
        }

        return answer;
    }

}
