package inflearn.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//아나그램 : 알파벳 나열 순서는 다르지만 그 구성이 일치하는 두 단어
public class Main4_2 {

    public static String solution(String s1, String s2) {

        Map<Character, Integer> map1 = StringToCharacterIntegerMap(s1);
        Map<Character, Integer> map2 = StringToCharacterIntegerMap(s2);

        for (char key : map1.keySet()) {
            if (!map1.get(key).equals(map2.get(key))) {
                return "NO";
            }
        }

        return "YES";
    }

    //문자열을 받아 key를 문자열의 각 문자, value를 해당 문자 개수로하는 맵을 반환
    private static Map<Character, Integer> StringToCharacterIntegerMap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    //강의 풀이
    private static String solution2(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return "NO";
            }

            map.put(c, map.get(c) - 1);
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));

        br.close();
    }
}
