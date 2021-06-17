// 풀이 날짜 : 2020-12-13
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12899

package programmers.level2;

public class _124나라의_숫자 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
             
        while(n > 0) {
            int remainder = n%3;
            
            if(remainder == 0) {
                sb.append(4);
            } else if(remainder == 1) {
                sb.append(1);
            } else {
                sb.append(2);
            }
                
            if(remainder == 0)  {
                n -= 1;
            }
                
            n /= 3;
        }
       
        return sb.reverse().toString();
    }
}
