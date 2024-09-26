package com.my.codingtest.programmers.level1;

public class PCCP_1번_동영상_재생기 {

    public static void main(String[] args) {
        String video_len_1 = "34:33"; // 동영상의 길이
        String pos_1 = "13:00"; // 기능이 수행되기 직전의 재생위치
        String op_start_1 = "00:55"; // 오프닝 시작 시각
        String op_end_1 = "02:55"; // 오프닝이 끝나는 시각
        String[] commands_1 = {"next", "prev"}; // 사용자의 입력

        String video_len_2 = "10:55";
        String pos_2 = "00:05";
        String op_start_2 = "00:15";
        String op_end_2 = "06:55";
        String[] commands_2 = {"prev", "next", "next"};

        String video_len_3 = "07:22";
        String pos_3 = "04:05";
        String op_start_3 = "00:15";
        String op_end_3 = "04:07";
        String[] commands_3 = {"next"};

        System.out.println(solution(video_len_3, pos_3, op_start_3, op_end_3, commands_3) + "");
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int videoLenSeconds = timeToSeconds(video_len);
        int posSeconds = timeToSeconds(pos);
        int opStartSeconds = timeToSeconds(op_start);
        int opEndSeconds = timeToSeconds(op_end);

        System.out.println(videoLenSeconds + " " + posSeconds + " " + opStartSeconds + " " + opEndSeconds);

        posSeconds = goToOpEnd(opStartSeconds, opEndSeconds, posSeconds);

        for(int i=0;i<commands.length;i++) {
            String command = commands[i];

            if(command.equals("prev")) {
                posSeconds -= 10;
                if(0 > posSeconds) {
                    posSeconds = 0;
                }
                posSeconds = goToOpEnd(opStartSeconds, opEndSeconds, posSeconds);
            } else if(command.equals("next")) {
                posSeconds += 10;
                if(videoLenSeconds < posSeconds) {
                    posSeconds = videoLenSeconds;
                }
                posSeconds = goToOpEnd(opStartSeconds, opEndSeconds, posSeconds);
            }
        }

        System.out.println(posSeconds + "!");

        answer = secondsToTime(posSeconds);

        return answer;
    }

    public static int timeToSeconds(String time) {
        String[] timeArr = time.split(":");
        int totalSeconds = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
        return totalSeconds;
    }

    public static String secondsToTime(int secondsTime) {
        int minutes = secondsTime / 60;
        int seconds = secondsTime % 60;
        String a = String.format("%02d", minutes);
        String b = String.format("%02d", seconds);
        return a + ":" + b;
    }

    public static int goToOpEnd(int opStartSeconds, int opEndSeconds, int posSeconds) {
        if(opStartSeconds <= posSeconds && posSeconds <= opEndSeconds) {
            posSeconds = opEndSeconds;
        }

        return posSeconds;
    }

}
