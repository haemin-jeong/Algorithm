// 날짜 : 2020-11-12
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/12916?language=java

package Programmers;

public class 문자열_내_P와_Y의_개수 {
    boolean solution(String s) {
        boolean answer = true;

        int yCount = 0;
        int pCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                yCount++;
            } else if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                pCount++;
            }
        }

        if (yCount != pCount) {
            return false;
        }

        return answer;
    }
}
