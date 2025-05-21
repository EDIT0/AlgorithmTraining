package com.my.codingtest.baekjoon.silver;

import java.util.*;
import java.io.*;

public class 구현_s2_20006 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;

            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<Model> roomList = new ArrayList<>();

            for(int i=0;i<p;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int l = Integer.parseInt(st.nextToken());
                String n = st.nextToken();
                boolean newRoomKey = true;

                if(roomList.isEmpty()) {
                    HashMap<String, Integer> map = new HashMap<String, Integer>();
                    map.put(n, l);
                    roomList.add(new Model(l, map));
                    continue;
                }

                for(int j=0;j<roomList.size();j++) {
                    int standardLevel = roomList.get(j).standardLevel;
                    if(standardLevel-10 <= l && standardLevel+10 >= l && roomList.get(j).hashMap.size() < m) {
                        roomList.get(j).hashMap.put(n, l);
                        newRoomKey = false;
                        break;
                    }
                }

                if(newRoomKey) {
                    HashMap<String, Integer> map = new HashMap<String, Integer>();
                    map.put(n, l);
                    roomList.add(new Model(l, map));
                }
            }

            for(int i=0;i<roomList.size();i++) {
                if(roomList.get(i).hashMap.size() == m) {
                    bw.write("Started!\n");
                } else {
                    bw.write("Waiting!\n");
                }

                Map<String, Integer> sortedMap = new TreeMap<>(roomList.get(i).hashMap);
                for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                    bw.write(entry.getValue() + " " + entry.getKey() + "\n");
                }
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static class Model {
        int standardLevel;
        HashMap<String, Integer> hashMap;

        Model(int l, HashMap<String, Integer> map) {
            standardLevel = l;
            hashMap = map;
        }
    }
}
