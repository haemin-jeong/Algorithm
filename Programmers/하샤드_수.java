// 풀이 날짜 : 2020-11-15
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12947

package Programmers;

public class 하샤드_수 {

    public boolean solution(int x) {
        String s= String.valueOf(x);
        int sum = 0;
        
        for(int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        
        if(x%sum == 0) {
            return true;
        } else {
            return false;
        }
        
    }
}
