package programmers.level2;

import java.util.*;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        List<String> strs = new ArrayList<>();

        for (int number : numbers) {
            strs.add(String.valueOf(number));
        }

        Collections.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1+ s2));

        if(strs.get(0).equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        strs.stream().forEach(sb::append);

        return sb.toString();
    }
}
