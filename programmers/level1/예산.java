// 풀이 날짜 : 2020-11-16
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12982

package programmers.level1;

import java.util.*;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        
        Arrays.sort(d);
        
        for(int n : d) {
            sum += n;
            
            if(sum > budget) {
                break;
            }
            
            answer++;
        }
        
        return answer;
    }
}
