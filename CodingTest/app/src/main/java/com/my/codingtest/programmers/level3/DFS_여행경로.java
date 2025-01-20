package com.my.codingtest.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DFS_여행경로 {

    public static void main(String[] args) {
        String[][] tickets1 = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };
        // ["ICN", "JFK", "HND", "IAD"]

        String[][] tickets2 = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };
        // ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]

        String[][] tickets3 = {{"ICN", "COO"}, {"COO", "ICN"},{"COO", "ICN"}};

        String[][] tickets4 = {
                {"ICN","BOO" },
                { "ICN", "COO" },
                { "COO", "DOO" },
                {"DOO", "COO"},
                { "BOO", "DOO"} ,
                {"DOO", "BOO"},
                {"BOO", "ICN" },
                {"COO", "BOO"}
        };
        // ['ICN', 'BOO', 'DOO', 'BOO', 'ICN', 'COO', 'DOO', 'COO', 'BOO']

        System.out.println(Arrays.toString(solution(tickets2)));
    }

    public static ArrayList<String> routeCase;
    public static boolean[] visited;

    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        routeCase = new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs(tickets, "ICN", "ICN", 0);

        Collections.sort(routeCase);
//        for(int i=0;i<routeCase.size();i++) {
//            System.out.println(routeCase.get(i));
//        }
        answer = routeCase.get(0).split(" ");

        return answer;
    }

    public static void dfs(String[][] tickets, String start, String arrive, int count) {
        if(tickets.length == count) {
            System.out.println(arrive);
            routeCase.add(arrive);
            return;
        }

        for(int i=0;i<tickets.length;i++) {
            if(!visited[i] && tickets[i][0].equals(start)) { // 출발지를 찾아서
                visited[i] = true;
                // 도착지([i][1])를 출발지(start)에 넣고, 도착지를 String 형태로 더해준다.
                dfs(tickets, tickets[i][1], arrive + " " + tickets[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
    
}
