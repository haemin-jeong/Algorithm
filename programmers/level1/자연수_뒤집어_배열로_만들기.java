// 날짜 : 2020-11-14
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/12932

package programmers.level1;

public class 자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        String s = Long.toString(n);
        int[] answer = new int[s.length()];
        int index = 0;
        
        for(int i = s.length()-1; i >= 0; i--) {
            answer[index++] = s.charAt(i) - '0';
        }
        
        return answer;
    }
}
