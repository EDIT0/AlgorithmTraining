package com.my.codingtest.programmers.level2;

public class JadenCase_문자열_만들기 {

    public static void main(String[] args) {
        String s1 = "3people unFollowed me";
        // "3people Unfollowed Me"
        String s2 = "for the last week";
        // "For The Last Week"

        System.out.println(solution(s1));
    }

    public static String solution(String s) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        boolean isTurnUpper = true;

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            System.out.println(c);
            if(c == ' ') {
                sb.append(" ");
                isTurnUpper = true;
                continue;
            }

            if(isTurnUpper) {
                // 공백 이후 첫번째 숫자면 실행
                if(c >= '0' && c <= '9') {
                    // 숫자는 패스
                    sb.append(c);
                } else if(c >= 'a' && c <= 'z'){
                    // 소문자면 대문자로 변환
                    c -= 32;
                    sb.append(c);
                } else {
                    sb.append(c);
                }
                isTurnUpper = false;
            } else if(c >= 'A' && c <= 'Z') {
                // 단어 중간에 대문자가 있다면 실행
                c += 32;
                sb.append(c);
            } else {
                sb.append(c);
            }
        }

        answer = sb.toString();

        return answer;
    }
    
}
