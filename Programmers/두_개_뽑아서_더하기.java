// 날짜 : 2020-11-4
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/68644

package Programmers;

import java.util.*;

public class 두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {
        int[] answer = null;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(n -> n.intValue()).toArray();
    }
}
