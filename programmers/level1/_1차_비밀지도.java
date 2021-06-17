// 풀이 날짜 : 2020-11-16
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/17681

package programmers.level1;

public class _1차_비밀지도 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = null;
        
        for(int i = 0; i < n; i++) {
            sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder sb2 = new StringBuilder(Integer.toBinaryString(arr2[i]));
            
            int len = n-sb1.length();
            for(int j = 0; j < len; j++) {
                sb1.insert(0,0);
            }
            
            len = n-sb2.length();
            for(int j = 0; j < len; j++) {
                sb2.insert(0,0);
            }
            
            for(int j = 0; j < n; j++) {
                if(sb1.charAt(j) == '1' || sb2.charAt(j) == '1') {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}
