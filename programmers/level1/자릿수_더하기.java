// 날짜 : 2020-11-14
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/12931

package programmers.level1;

public class 자릿수_더하기 {
    public int solution(int n) {
        int sum = 0;
        String s = Integer.toString(n);
        
        for(int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        
        return sum;
    }
}
