// 날짜 : 2020-11-12
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/70128

package programmers.level1;

public class 내적 {
    public int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }
}
