//날짜 : 2020-11-10
//출처 : https://programmers.co.kr/learn/courses/30/lessons/68935

package Programmers;

import java.util.*;

public class 3진법_뒤집기 {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] arr = null;
        int answer = 0;
        
        while(n >= 3) {
            sb.append(n%3);
            n  = n/3;
        }
        
        sb.append(n);
        sb.reverse();
        
        arr = sb.toString().split("");
        
        for(int i = 0; i < arr.length; i++) {
            answer += Integer.parseInt(arr[i]) * Math.pow(3,i);
        }
        
        return answer;
        
    }
}
