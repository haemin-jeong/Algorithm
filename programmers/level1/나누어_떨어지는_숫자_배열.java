// 날짜 : 2020-11-11
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/12910

package programmers.level1;

import java.util.*;

public class 나누어_떨어지는_숫자_배열 {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }

        if (list.size() == 0) {
            return new int[] { -1 };
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
