// 풀이 날짜 : 2020-11-28
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42586

package programmers.level2;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> days = new ArrayList<>();
        
        //각 작업 당 필요한 날짜 수 계산
        for(int i = 0; i < progresses.length; i++) {
            if((100-progresses[i])%speeds[i] == 0) {
                days.add((100-progresses[i])/speeds[i]);
            } else {
                days.add((100-progresses[i])/speeds[i] + 1);
            }
        }
        
        // 각 배포시마다 몇 개의 기능을 배포할 수 있는지 계산
        int index = 0;
        for(int i = 1; i < days.size(); i++) {
            if(days.get(i) > days.get(index)) {
                answer.add(i-index);
                index = i;
            }
        }
        answer.add(days.size() - index);
        

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
