package com.my.codingtest.programmers.level1;

import java.util.*;

class 해시_폰켓몬 {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 3, 3, 2, 2, 2};

        System.out.println(solution(nums));
    }

    public static int solution(int[] nums)  {
        int answer = 0;

        Map<Integer, Boolean> hashMap = new HashMap();

        for(int i=0;i<nums.length;i++) {
            hashMap.put(nums[i], true);
        }

        if(hashMap.size() <= (nums.length / 2)) {
            answer = hashMap.size();
        } else {
            answer = nums.length / 2;
        }

        return answer;
    }
}
