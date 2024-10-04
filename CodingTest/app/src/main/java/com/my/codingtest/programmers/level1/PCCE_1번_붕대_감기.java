package com.my.codingtest.programmers.level1;

public class PCCE_1번_붕대_감기 {

    public static void main(String[] args) {
        int[] bandage1 = {5, 1, 5};
        int health1 = 30;
        int[][] attacks1 = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        // 5

        int[] bandage2 = {3, 2, 7};
        int health2 = 20;
        int[][] attacks2 = {{1, 15}, {5, 16}, {8, 6}};
        // -1

        int[] bandage3 = {4, 2, 7};
        int health3 = 20;
        int[][] attacks3 = {{1, 15}, {5, 16}, {8, 6}};
        // -1

        int[] bandage4 = {1, 1, 1};
        int health4 = 5;
        int[][] attacks4 = {{1, 2}, {3, 2}};
        // 3

        System.out.println(solution(bandage4, health4, attacks4) + "");
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        // 기술의 시전 시간, 1초당 회복량, 추가 회복량 bandage
        // 최대 체력 health
        // 몬스터의 공격 시간과 피해량 attacks


        // 조건 1. t초 동안 붕대를 감으면서 1초마다 x만큼의 체력을 회복합니다. t초 연속으로 붕대를 감는 데 성공한다면 y만큼의 체력을 추가로 회복
        // 조건 2. 최대 체력이 존재해 현재 체력이 최대 체력보다 커지는 것은 불가능
        // 조건 3. 몬스터에게 공격당해 기술이 취소당하거나 기술이 끝나면 그 즉시 붕대 감기를 다시 사용하며, 연속 성공 시간이 0으로 초기화
        // 조건 4. 몬스터의 공격을 받으면 정해진 피해량만큼 현재 체력이 줄어듭니다. 이때, 현재 체력이 0 이하가 되면 캐릭터가 죽으며 더 이상 체력을 회복할 수 없습니다.


        int attackIndex = 0;
        int termStack = 0;

        int fullHealth = health;
        int term = bandage[0];
        int recover = bandage[1];
        int additionalRecover = bandage[2];
        int lastSeconds = attacks[attacks.length - 1][0]; // 몬스터 마지막 공격 시간(초)

        for(int i=1;i<=lastSeconds;i++) {
            if(attacks[attackIndex][0] == i) {
                health -= attacks[attackIndex][1];
                termStack = 0;
                attackIndex += 1;
                if(health <= 0) {
                    health = -1;
                    break;
                }
            } else {
                health += recover;
                termStack += 1;
                if(termStack == term) {
                    health += additionalRecover;
                    termStack = 0;
                }
                if(health > fullHealth) {
                    health = fullHealth;
                }
            }
        }

        if(health != -1) {
            answer = health;
        } else {
            answer = -1;
        }

        return answer;
    }

}
