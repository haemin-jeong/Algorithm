// 풀이 날짜 : 2020-11-24
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42584

package programmers.level2;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0 ; i < prices.length; i++) {
            
            int second = 0;
            for(int j = i+1; j < prices.length; j++) {

                second++;
                
                if(prices[i] > prices[j]) {
                    break;
                }
                
                
            }
            answer[i] = second;
        }
        
        return answer;
    }
}
