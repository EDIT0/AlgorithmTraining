package com.my.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 개인정보_수집_유효기간_KAKAO {
    // 2023 KAKAO BLIND RECRUITMENT

    public static void main(String[] args) {
        String today1 = "2022.05.19";
        String[] terms1 = {"A 6", "B 12", "C 3"};
        String[] privacies1 = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        String today2 = "2020.01.01";
        String[] terms2 = {"Z 3", "D 5"};
        String[] privacies2 = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};


        System.out.println(Arrays.toString(solution(today2, terms2, privacies2)) + "");
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        Map<String, Integer> hashMap = new HashMap<>();

        for (int i=0;i<terms.length;i++) {
            String[] tmp = terms[i].split(" ");
            hashMap.put(tmp[0],Integer.parseInt(tmp[1]));
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<privacies.length;i++) {
            String[] tmp = privacies[i].split(" ");
            int month = hashMap.get(tmp[1]);
            String newDate = changeDate(tmp[0], month);
            int r = isSame(today, newDate);

            if(r == 1) {
                result.add(i+1);
            }
        }

        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    // 마이너스 month는 없음
    public static String changeDate(String date, int month) {
        String[] dateArr = date.split("\\.");

        int currentYear = Integer.parseInt(dateArr[0]);
        int currentMonth = Integer.parseInt(dateArr[1]);

        int addYear = month / 12;
        int addMonth = month % 12;

        int afterYear = currentYear + addYear;
        int afterMonth = currentMonth + addMonth;

        if(afterMonth > 12) {
            afterMonth -= 12;
            afterYear += 1;
        }

        return afterYear + "." + String.format("%02d", afterMonth) + "." + dateArr[2];
    }

    // 1=같음, 1=date1가 큼, 2=date2가 큼
    public static int isSame(String date1, String date2) {
        String[] date1Arr = date1.split("\\.");
        String[] date2Arr = date2.split("\\.");

        if(Integer.parseInt(date1Arr[0]) == Integer.parseInt(date2Arr[0])) {
            if(Integer.parseInt(date1Arr[1]) == Integer.parseInt(date2Arr[1])) {
                if(Integer.parseInt(date1Arr[2]) == Integer.parseInt(date2Arr[2])) {
                    return 1;
                } else {
                    if(Integer.parseInt(date1Arr[2]) > Integer.parseInt(date2Arr[2])) {
                        return 1;
                    } else {
                        return 2;
                    }
                }
            } else {
                if(Integer.parseInt(date1Arr[1]) > Integer.parseInt(date2Arr[1])) {
                    return 1;
                } else {
                    return 2;
                }
            }
        } else {
            if(Integer.parseInt(date1Arr[0]) > Integer.parseInt(date2Arr[0])) {
                return 1;
            } else {
                return 2;
            }
        }
    }
}
