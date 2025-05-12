package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 구현_s5_20546 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int days = 14;
            int totalMoney = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            ArrayList<Integer> pricePerDay = new ArrayList<>();
            HashMap<Integer, Integer> person1Map = new HashMap<>();
            HashMap<Integer, Integer> person2Map = new HashMap<>();
            int person1 = 0;
            int person2 = 0;

            for(int i=0;i<days;i++) {
                pricePerDay.add(Integer.parseInt(st.nextToken()));
            }

            int wallet = totalMoney;
            int sum = 0;

            for(int i=0;i<days;i++) {
                int num = wallet / pricePerDay.get(i);
                if(num > 0) {
                    person1Map.put(i, num);
                    wallet = wallet % pricePerDay.get(i);
                }
            }

            for(Map.Entry<Integer, Integer> entry : person1Map.entrySet()) {
                sum += (pricePerDay.get(days-1) * entry.getValue());
            }

            person1 = wallet + sum;

            // 초기화
            wallet = totalMoney;
            sum = 0;
            int upDown = 0;

            for(int i=1;i<days;i++) {
                int y = pricePerDay.get(i-1);
                int t = pricePerDay.get(i);

                if(y == t) {
                    upDown = 0;
                } else if(y < t) {
                    if(upDown < 0) {
                        upDown = 1;
                    } else {
                        upDown += 1;
                    }
                } else {
                    if(upDown > 0) {
                        upDown = -1;
                    } else {
                        upDown -= 1;
                    }
                }

                if(upDown >= 3) {
                    for(Map.Entry<Integer, Integer> entry : person2Map.entrySet()) {
                        wallet += (pricePerDay.get(i) * entry.getValue());
                    }
                    person2Map.clear();
                } else if(upDown <= -3) {
                    int num = wallet / pricePerDay.get(i);
                    if(num > 0) {
                        person2Map.put(i, num);
                        wallet = wallet % pricePerDay.get(i);
                    }
                }
            }

            for(Map.Entry<Integer, Integer> entry : person2Map.entrySet()) {
                sum += (pricePerDay.get(days-1) * entry.getValue());
            }

            person2 = wallet + sum;

            String answer = "";
            if(person1 == person2) {
                answer = "SAMESAME";
            } else if(person1 > person2) {
                answer = "BNP";
            } else {
                answer = "TIMING";
            }
            bw.write(answer);

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
