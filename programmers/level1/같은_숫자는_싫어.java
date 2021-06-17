// 날짜 : 2020-11-10
//출처 : https://programmers.co.kr/learn/courses/30/lessons/12906

package programmers.level1;

import java.util.*;

public class 같은_숫자는_싫어 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        int prev = arr[0];
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (prev == arr[i]) {
                continue;
            }

            list.add(arr[i]);
            prev = arr[i];
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
