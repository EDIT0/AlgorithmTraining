package com.my.codingtest.baekjoon.silver;

import java.io.*;

public class 문자열_s5_4659 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            while (true) {
                String input = br.readLine();

                if(input.equals("end")) {
                    break;
                }

                if(!check1(input)) {
                    bw.write("<" + input + "> is not acceptable.\n");
                } else {
                    if(!check2(input)) {
                        bw.write("<" + input + "> is not acceptable.\n");
                    } else {
                        if(!check3(input)) {
                            bw.write("<" + input + "> is not acceptable.\n");
                        } else {
                            bw.write("<" + input + "> is acceptable.\n");
                        }
                    }
                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    // 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
    public static boolean check1(String input) {
        if(input.contains("a") || input.contains("e") || input.contains("i") || input.contains("o") || input.contains("u")) {
            return true;
        } else {
            return false;
        }
    }

    // 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
    public static boolean check2(String input) {
        int count1 = 0;
        int count2 = 0;

        for(int i=0;i<input.length();i++) {
            if(check1(String.valueOf(input.charAt(i)))) {
                count1 += 1;
                count2 = 0;
            } else {
                count2 += 1;
                count1 = 0;
            }

            if(count1 >= 3 || count2 >= 3) {
                return false;
            }
        }

        return true;
    }

    // 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
    public static boolean check3(String input) {
        String save = "";

        for(int i=1;i<input.length();i++) {
            save = String.valueOf(input.charAt(i-1));
            if(save.equals(String.valueOf(input.charAt(i)))) {
                if(save.equals("e") || save.equals("o")) {
                    continue;
                } else {
                    return false;
                }
            }

        }

        return true;
    }
}
