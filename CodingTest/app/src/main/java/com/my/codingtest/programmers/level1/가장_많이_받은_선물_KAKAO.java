package com.my.codingtest.programmers.level1;

import java.util.*;

public class 가장_많이_받은_선물_KAKAO {
    public static void main(String[] args) {
        String[] friends1 = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts1 = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        // 2

        String[] friends2 = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts2 = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        // 4

        String[] friends3 = {"a", "b", "c"};
        String[] gifts3 = {"a b", "b a", "c a", "a c", "a c", "c a"};
        // 0

        System.out.println(solution(friends1, gifts1) + "");
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        // 친구들의 이름을 담은 1차원 문자열 배열 friends
        // 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 gifts

        Model[] friendsModel = new Model[friends.length]; // 정보 객체 배열
        for(int i=0;i<friends.length;i++) {
            friendsModel[i] = new Model(friends[i], 0, 0, 0);
        }

        Map<String, Integer> hashMap = new HashMap<>();
        for(int i=0;i<gifts.length;i++) {
            String[] sub = gifts[i].split(" ");
            String key = sub[0] + " " + sub[1];
            if(hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }

            for(int j=0;j<friendsModel.length;j++) {
                if(friendsModel[j].name.equals(sub[0])) {
                    friendsModel[j].a = friendsModel[j].a + 1;
                    friendsModel[j].c = friendsModel[j].a - friendsModel[j].b;
//                    if(!friendsModel[j].history.contains(sub[1])) {
//                        friendsModel[j].history.add(sub[1]);
//                    }
                }
            }

            for(int k=0;k<friendsModel.length;k++) {
                if(friendsModel[k].name.equals(sub[1])) {
                    friendsModel[k].b = friendsModel[k].b + 1;
                    friendsModel[k].c = friendsModel[k].a - friendsModel[k].b;
//                    if(!friendsModel[k].history.contains(sub[0])) {
//                        friendsModel[k].history.add(sub[0]);
//                    }
                }
            }
        }

//        for(int i=0;i<friendsModel.length;i++) {
//            System.out.println(friendsModel[i]);
//        }
//        for(int i=0;i<friendsModel.length;i++) {
//            for(int j=0;j<friendsModel.length;j++) {
//                if(hashMap.containsKey(friendsModel[i].name + " " + friendsModel[j].name)) {
//                    System.out.print(" " + hashMap.get(friendsModel[i].name + " " + friendsModel[j].name) + " ");
//                } else {
//                    System.out.print(" - ");
//                }
//            }
//            System.out.println();
//        }

        // 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
        // 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
        // * 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
        // 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.

        for(int i=0;i<friendsModel.length;i++) {
            int giftSum = 0;
            for(int j=0;j<friendsModel.length;j++) {
                if(!friendsModel[i].name.equals(friendsModel[j].name)) {
                    int giftCount1 = 0;
                    int giftCount2 = 0;
                    if(hashMap.containsKey(friendsModel[i].name + " " + friendsModel[j].name)) {
                        giftCount1 = hashMap.get(friendsModel[i].name + " " + friendsModel[j].name);
                    }
                    if(hashMap.containsKey(friendsModel[j].name + " " + friendsModel[i].name)) {
                        giftCount2 = hashMap.get(friendsModel[j].name + " " + friendsModel[i].name);
                    }

                    if(giftCount1 > giftCount2) {
                        giftSum += 1;
                    } else if(giftCount1 == giftCount2){
                        if(friendsModel[i].c > friendsModel[j].c) {
                            giftSum += 1;
                        }
                    }
                }
            }
            answer = Math.max(answer, giftSum);
        }

//        System.out.println(answer);

        return answer;
    }

    public static class Model {
        String name = "";
        int a = 0; // 준 선물
        int b = 0; // 받은 선물
        int c = 0; // 선물 지수
        public Model(String name, int a, int b, int c) {
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return name + "/" + a + "/" + b + "/" + c;
        }
    }
}
