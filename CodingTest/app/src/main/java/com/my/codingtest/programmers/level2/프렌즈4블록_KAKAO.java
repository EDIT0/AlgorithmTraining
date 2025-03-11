package com.my.codingtest.programmers.level2;

public class 프렌즈4블록_KAKAO {

    public static void main(String[] args) {
        int m1 = 4;
        int n1 = 5;
        String[] board1 = {
                "CCBDE",
                "AAADE",
                "AAABF",
                "CCBBF"
        };
        // 14

        int m2 = 6;
        int n2 = 6;
        String[] board2 = {
                "TTTANT",
                "RRFACC",
                "RRRFCC",
                "TRRRAA",
                "TTMMMF",
                "TMMTTJ"
        };
        // 15

        int m3 = 8;
        int n3 = 5;
        String[] board3 = {
                "HGNHU",
                "CRSHV",
                "UKHVL",
                "MJHQB",
                "GSHOT",
                "MQMJJ",
                "AGJKK",
                "QULKK"
        };
        // 8



        System.out.println(solution(m3, n3, board3) + "");
    }

    public static boolean[][] isCheck;
    public static boolean isRestart = false;
    public static int destroyBlock = 0;

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        String[][] newBoard = new String[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                newBoard[i][j] = String.valueOf(board[i].charAt(j));
            }
        }

        isCheck = new boolean[m][n];

        newBoard = check(m, n, newBoard);

        while (isRestart) {
            isRestart = false;
            newBoard = check(m, n, newBoard);
        }

        answer = destroyBlock;

        return answer;
    }

    public static String[][] check(int m, int n, String[][] newBoard) {
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                String target = newBoard[i][j];
                if(target.equals(" ")) {
                    continue;
                }
                if(i < m-1 && j < n-1) {
                    if(target.equals(newBoard[i][j+1])
                            && target.equals(newBoard[i+1][j])
                            && target.equals(newBoard[i+1][j+1])
                    ) {
                        isRestart = true;
                        isCheck[i][j] = true;
                        isCheck[i][j+1] = true;
                        isCheck[i+1][j] = true;
                        isCheck[i+1][j+1] = true;
                    }
                }
            }
        }

        // check
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(isCheck[i][j] + " ");
            }
            System.out.println();
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(isCheck[i][j]) {
                    destroyBlock += 1;

                    if(i-1 >= 0) {
                        // 칸 채우기
                        for(int k=i;k>0;k--) {
                            newBoard[k][j] = newBoard[k-1][j];
                            newBoard[k-1][j] = " ";
                        }
                    } else {
                        newBoard[i][j] = " ";
                    }
                }
            }
        }

        isCheck = new boolean[m][n];

        // check
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(newBoard[i][j] + " ");
            }
            System.out.println();
        }

        return newBoard;
    }

}
