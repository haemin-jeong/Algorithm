// 풀이 날짜 : 2020-11-14
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12934
package programmers.level1;

public class 정수_제곱근_판별 {
    public long solution(long n) {
        double x = Math.sqrt(n);

        if((int)x != x) {
            return -1;
        } 
        
        return (long)((x +1)*(x +1));
    }
}
