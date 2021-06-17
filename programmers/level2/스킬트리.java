// 풀이 날짜 : 2020-12-12
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/49993

package Programmers.Level2;

import java.util.*;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        // 스킬트리 문자열에서 선행 스킬을 제외한 나머지 스킬 제거
        for(int i = 0; i < skill_trees.length; i++) {
            skill_trees[i] = skill_trees[i].replaceAll("[^"+ skill + "]", "");
        }
        

        for(String s : skill_trees) {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != skill.charAt(i)) {
                    answer--;
                    break;
                }
            }    
        }
        
        return answer;
    }
}
