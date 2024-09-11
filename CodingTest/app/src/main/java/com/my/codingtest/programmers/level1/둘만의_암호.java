package com.my.codingtest.programmers.level1;

public class 둘만의_암호 {

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        String s2 = "uvwxyz";
        String skip2 = "abcde";
        int index2 = 20;

        System.out.println(solution(s, skip, index) + "");
    }

    public static String solution(String s, String skip, int index) {
        String answer = "";

        String[] alphabetArr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        int currentIndex = 0;
        int count = 0;

        for(int i=0;i<s.length();i++) {
            String item = String.valueOf(s.charAt(i));
            currentIndex = alphabetString.indexOf(item);
            currentIndex += 1;
            while (count < index) {
                if(currentIndex == 26) {
                    currentIndex = 0;
                }

                String a = alphabetArr[currentIndex];
                if(skip.contains(a)) {

                } else {
                    count += 1;
                }
                currentIndex += 1;
            }

            if(currentIndex == 0) currentIndex = 26;
            answer += alphabetArr[currentIndex-1]; // count 올리면서 currentIndex도 올리기 때문에 -1
            count = 0;
        }

        return answer;
    }

}
