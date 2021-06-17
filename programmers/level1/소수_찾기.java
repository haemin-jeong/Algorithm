// 풀이 날짜 : 2020-11-19
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/12921

package programmers.level1;

public class 소수_찾기 {
    class Solution {
        //에라토스테네스 체 알고리즘 이용하여 풀이
        public int solution(int n) {
            int answer = 0;
            int[] arr = new int[n+1];
            
            for(int i = 1; i <= n; i++) {
                arr[i] = i;
            }
            
            for(int i = 2; i <= n; i++) {
                if(arr[i] == 0) continue;
                
                for(int j = i+i; j <= n; j+= i) {
                    arr[j] = 0;
                }
            }
            
            for(int i = 2; i <= n; i++) {
                if(arr[i] != 0) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
