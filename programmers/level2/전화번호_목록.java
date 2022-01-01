package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Map<String, String> map = new HashMap<>();

        for(String s : phone_book) {
            map.put(s, null);
        }

        for(String s : phone_book) {
            for(int i = 0; i < s.length(); i++) {
                if(map.containsKey(s.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
