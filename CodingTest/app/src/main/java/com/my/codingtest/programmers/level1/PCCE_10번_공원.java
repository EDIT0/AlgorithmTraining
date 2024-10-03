package com.my.codingtest.programmers.level1;

public class PCCE_10번_공원 {

    public static void main(String[] args) {
        int[] mats1 = {5,3,2};
        String[][] park1 = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };


        System.out.println(solution(mats1, park1) + "");
    }

    public static int solution(int[] mats, String[][] park) {
        int answer = -1;

        // 돗자리들의 한 변의 길이들이 담긴 정수 리스트 mats
        // 현재 공원의 자리 배치도를 의미하는 2차원 문자열 리스트 park
        boolean isFail = false;
        for(int i=0;i<park.length;i++) {
            for(int j=0;j<park[i].length;j++) {
                if(park[i][j].equals("-1")) {
                    for(int k=0;k<mats.length;k++) {
                        int size = mats[k];
                        if(park.length < size+i || park[0].length < size+j) { // 범위를 벗어나면 어차피 못깔음
                            continue;
                        }
                        isFail = false;
                        for(int x=i;x<size+i;x++) {
                            for(int y=j;y<size+j;y++) {
                                if(!park[x][y].equals("-1")) {
                                    isFail = true; // 못깐다는 플래그
                                    break;
                                }
                            }
                            if(isFail) {
                                break;
                            }
                        }
                        if(!isFail) {
                            if(answer < size) {
                                answer = size;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

}
