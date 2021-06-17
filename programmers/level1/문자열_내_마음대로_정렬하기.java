// 날짜 : 2020-11-12
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/12915

package programmers.level1;

import java.util.*;

public class 문자열_내_마음대로_정렬하기 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2);
            }

            return s1.charAt(n) - s2.charAt(n);
        });

        return strings;
    }
}
