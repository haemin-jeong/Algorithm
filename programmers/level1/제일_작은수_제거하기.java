// 풀이 날짜 : 2020-11-15
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12935

package programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class 제일_작은수_제거하기 {
    public int[] solution(int[] arr) {
        if(arr.length == 1) {
            return new int[]{-1};
        }
        
        List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        list.remove(list.remove(Collections.min(list)));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
