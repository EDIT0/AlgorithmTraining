package com.my.codingtest.programmers.level1;

public class 소수_만들기 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {1,2,7,6,4};

        System.out.println(solution(nums2) + "");
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for(int i=0;i<=nums.length-3;i++) {
            int x = nums[i];
            for(int j=i+1;j<=nums.length-2;j++) {
                int y = nums[j];
                for(int k=j+1;k<=nums.length-1;k++) {
                    int z = nums[k];
                    if(isPrimeNumber(x+y+z)) {
                        answer += 1;
                    }
                }
            }
        }

        return answer;
    }

    public static boolean isPrimeNumber(long n) {
        if (n <= 1) return false; // 1보다 작은면 소수x
        if (n <= 3) return true; // 2, 3은 소수o
        if (n % 2 == 0 || n % 3 == 0) return false; // 2나 3으로 나누어 떨어지면 소수x

        for (long i = 4; i * i <= n; i++) {
            if (n % i == 0) { // 나누어 떨어지는 숫자가 있으면 소수가 아님
                return false;
            }
        }

        return true;
    }
}
