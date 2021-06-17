// 풀이 날짜 : 2020-11-16
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12954#

package programmers.level1;

public class x만큼_간격이_있는_n개의_숫자 {
    //int*int -> int 이므로 x를 long형을 바꿔주지않으면 오버플로우가 발생한다.
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long lx = x;
        for(int i = 0; i < n ; i++) {
            answer[i] = lx*(i+1);
        }
    
        return answer;
}
}
