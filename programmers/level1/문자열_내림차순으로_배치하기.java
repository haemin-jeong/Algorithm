// 날짜 : 2020-11-12
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/12917

package programmers.level1;

import java.util.*;

public class 문자열_내림차순으로_배치하기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
