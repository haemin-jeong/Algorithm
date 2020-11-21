//날짜 : 2020-11-14
//출처 : https://programmers.co.kr/learn/courses/30/lessons/12930

package Programmers;

import java.util.*;

public class 이상한_문자_만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("");
        int count = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals(" ")) {
                sb.append(" ");
                count = 0;
                continue;
            }
            
            if(count%2 == 0) {
                sb.append(arr[i].toUpperCase());
            } else {
                sb.append(arr[i].toLowerCase());
            }
            
            count++;
        }
        
        return sb.toString();
    }
}
