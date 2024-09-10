package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 대충_만든_자판 {

    public static void main(String[] args) {
        String[] keymap1 = {"ABACD", "BCEFD"};
        String[] targets1 = {"ABCD","AABB"};

        String[] keymap2 = {"AA"};
        String[] targets2 = {"B"};

        String[] keymap3 = {"AGZ", "BSSS"};
        String[] targets3 = {"ASA","BGZ"};

        String[] keymap4 = {"ABCDE"};
        String[] targets4 = {"FGHIJ"};

        System.out.println(Arrays.toString(solution(keymap1, targets1)) + "");
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};

        answer = new int[targets.length];

        for(int i=0;i<targets.length;i++) {
            int sum = 0;
            for(int j=0;j<targets[i].length();j++) {
                String alphabet = String.valueOf(targets[i].charAt(j));
                int min = Integer.MAX_VALUE;
                boolean found = false;

                for(int k=0;k< keymap.length;k++) {
                    if(keymap[k].contains(alphabet)) {
                        if (min > keymap[k].indexOf(alphabet)) {
                            min = keymap[k].indexOf(alphabet);
                            found = true;
                        }
                    }
                }
                if (!found) {
                    sum = -1;  // 문자를 찾을 수 없으면 -1을 할당하고 루프 종료
                    break;
                } else {
                    sum += (min + 1);  // 인덱스는 0부터 시작하므로 +1
                }
            }

            answer[i] = sum;

        }

        return answer;
    }
}
