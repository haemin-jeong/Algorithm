// 풀이 날짜 : 2020-11-14
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12933

package programmers.level1;

import java.util.*;

public class 정수_내림차순으로_배치하기 {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        char[] arr = Long.toString(n).toCharArray();
        
        Arrays.sort(arr);
        
        for(int i = arr.length-1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}
