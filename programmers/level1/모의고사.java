// 날짜 : 2020-11-4;
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/42840
package programmers.level1;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[] index = new int[3];

        int[] person1 = { 1, 2, 3, 4, 5 };
        int[] person2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] person3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        for (int i = 0; i < answers.length; i++) {
            if (index[0] == person1.length) {
                index[0] = 0;
            }

            if (index[1] == person2.length) {
                index[1] = 0;
            }

            if (index[2] == person3.length) {
                index[2] = 0;
            }

            if (person1[index[0]] == answers[i]) {
                score[0]++;
            }

            if (person2[index[1]] == answers[i]) {
                score[1]++;
            }

            if (person3[index[2]] == answers[i]) {
                score[2]++;
            }

            index[0]++;
            index[1]++;
            index[2]++;
        }

        int max = Arrays.stream(score).max().getAsInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                list.add(i + 1);
            }
        }

        return list.stream().sorted().mapToInt(n -> n.intValue()).toArray();
    }
}
