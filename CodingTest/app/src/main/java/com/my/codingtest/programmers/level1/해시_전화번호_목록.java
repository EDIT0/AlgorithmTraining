package com.my.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class 해시_전화번호_목록 {

    public static void main(String[] args) {
        String[] phone_book = new String[] {"12","123","1235","567","88"};

        System.out.println(solution2(phone_book));
    }

    /**
     * 해시 사용 O
     * */
    public static boolean solution1(String[] phone_book) {
        boolean answer = true;

//        for(int i=0;i<phone_book.length;i++) {
//            String num = phone_book[i];
//            for(int j=0;j<phone_book.length;j++) {
//                if(num == phone_book[j]) continue;
//                else {
//                    if(num.length() <= phone_book[j].length()) {
//                        boolean isContain = num.contains(phone_book[j].substring(0, num.length()));
//                        if(isContain) {
//                            answer = false;
//                            return answer;
//                        }
//                    }
//                }
//            }
//        }

        return answer;
    }

    /**
     * 해시 사용 X
     * */
    public static boolean solution2(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=0;i<phone_book.length-1;i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return answer;
    }



}