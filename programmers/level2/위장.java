package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;

        for(String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1); //해당 종류 의상을 안입는 경우 1을 더해준다.
        }

        //모든 의상을 입지 않는 경우 1을 빼준다.
        return answer - 1;
    }
}
