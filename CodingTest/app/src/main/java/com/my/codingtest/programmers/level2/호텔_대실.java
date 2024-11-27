package com.my.codingtest.programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔_대실 {

    public static void main(String[] args) {
        String[][] book_time_1 = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        // 3
        String[][] book_time_2 = {{"09:10", "10:10"}, {"10:20", "12:20"}};
        // 1
        String[][] book_time_3 = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
        // 3

        System.out.println(solution(book_time_1));
    }

    public static int solution(String[][] book_time) {
        int answer = 0;

        Arrays.sort(book_time, (o1, o2) -> {
            String[] tmp1 = o1[0].split(":");
            String[] tmp2 = o2[0].split(":");
            int hour1 = Integer.parseInt(tmp1[0]);
            int minute1 = Integer.parseInt(tmp1[1]);
            int hour2 = Integer.parseInt(tmp2[0]);
            int minute2 = Integer.parseInt(tmp2[1]);

            if(hour1 > hour2) {
                return 1;
            } else if(hour1 == hour2){
                if(minute1 > minute2) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        });

        for(int i=0;i<book_time.length;i++) {
            System.out.println(book_time[i][0] + " / " + book_time[i][1]);
        }

        PriorityQueue<Integer> roomQueue = new PriorityQueue<>(); // 내림차순으로 나옴

        for (String[] time : book_time) {
            int start = timeToMinute(time[0]);
            int end = timeToMinute(time[1]) + 10; // 청소 시간 10분 추가
            System.out.println("start " + start + " / end " + end);
            System.out.println(roomQueue.peek() + " <= " + start);
            // 현재 방들의 청소 완료 시간과 비교
            if (!roomQueue.isEmpty() && roomQueue.peek() <= start) {
                roomQueue.poll(); // 앞에 방 다 사용하였으므로 poll 하고 아래에서 새로 사용되는 시간으로 add 해준다.
            } else {
                answer++;
            }

            System.out.println("end 추가 " + end);
            System.out.println();
            roomQueue.add(end);
        }

        return answer;
    }

    public static int timeToMinute(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);

        return h * 60 + m;
    }
    
}
