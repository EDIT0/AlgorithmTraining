package com.my.codingtest.programmers.level1;

public class 옹알이_2 {

    public static void main(String[] args) {
        String[] babbling1 = {"aya", "yee", "u", "maa"};
        String[] babbling2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa", "mayaa", "ayayemaaya"};

        System.out.println(solution(babbling2) + "");
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        String[] possible = {"aya", "ye", "woo", "ma"};

        for(int i=0;i<babbling.length;i++) {
            String current = babbling[i]; // current : "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"

            int j =0;
            for(;j<possible.length;) {
//                System.out.println("j = " + j +" current : " + current);

                if(current.contains(possible[j])) {
                    int start = current.indexOf(possible[j]) + possible[j].length();

//                    System.out.println(start);
                    if(current.length() > start && current.length() >= (start + possible[j].length())) {
//                        System.out.println(current.substring(start, start + possible[j].length()));
                        String next = current.substring(start, start + possible[j].length());
//                        System.out.println("current: " + current + " next: " + next + " possible[j]: " + possible[j]);
                        if(!next.equals(possible[j])) {
                            String a = "";
                            for(int z=0;z<possible[j].length();z++) {
                                a += " ";
                            }
                            current = current.replaceFirst(possible[j], a);
                            j=0;
                            continue;
                        } else {
                            break;
                        }
                    } else {
                        String a = "";
                        for(int z=0;z<possible[j].length();z++) {
                            a += " ";
                        }
                        current = current.replaceFirst(possible[j], a);
                        j=0;
                        continue;
                    }
                }
                j++;
            }

            current = current.replace(" ", "");
            if(current.isEmpty()) {
                answer += 1;
//                System.out.println("+++ " + answer);
            }

        }

        return answer;
    }

}
