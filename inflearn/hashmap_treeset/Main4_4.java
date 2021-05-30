package inflearn.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//모든 아나그램 찾기
public class Main4_4 {

    public static int solution(String s, String t) {
        int answer = 0;
        
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length()-1; i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int left = 0;
        for (int right = t.length()-1; right < s.length(); right++) {
            smap.put(s.charAt(right), smap.getOrDefault(s.charAt(right), 0) + 1);

            if (smap.equals(tmap)) {
                answer++;
            }

            smap.put(s.charAt(left), smap.get(s.charAt(left)) - 1);

            if (smap.get(s.charAt(left)) == 0) {
                smap.remove(s.charAt(left));
            }

            left++;
       }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        System.out.println(solution(s, t));
    }
}
