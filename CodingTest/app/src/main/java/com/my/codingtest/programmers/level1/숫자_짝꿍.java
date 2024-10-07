package com.my.codingtest.programmers.level1;

public class 숫자_짝꿍 {
    public static void main(String[] args) {
        String X1 = "100";
        String Y1 = "2345";
        // -1

        String X2 = "100";
        String Y2 = "203045";
        // 0

        String X3 = "100";
        String Y3 = "123450";
        // 10

        String X4 = "12321";
        String Y4 = "42531";
        // 321

        String X5 = "5525";
        String Y5 = "1255";
        // 552


        System.out.println(solution(X5, Y5) + "");
    }

    public static String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (int i=0;i<X.length();i++) {
            countX[X.charAt(i) - '0'] += 1;
        }

        for (int i=0;i<Y.length();i++) {
            countY[Y.charAt(i) - '0'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9;i>=0;i--) {
            int count = Math.min(countX[i], countY[i]);
            if(count > 0) {
                for(int j=0;j<count;j++) {
                    sb.append(i);
                }
            }
        }
//        for (int i = 9; i >= 0; i--) {
//            // X와 Y에 공통으로 나타나는 숫자의 최소 빈도만큼 추가
//            int commonCount = Math.min(countX[i], countY[i]);
//            if (commonCount > 0) {
//                char[] repeatedChars = new char[commonCount];
//                Arrays.fill(repeatedChars, (char)(i + '0'));
//                sb.append(new String(repeatedChars));
//            }
//        }

        if (sb.length() == 0) {
            return "-1";
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
