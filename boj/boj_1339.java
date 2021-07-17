// 날짜 : 2020-10-29
// 출처 : https://www.acmicpc.net/problem/1339

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (!map.containsKey(words[i].charAt(j))) {
                    map.put(words[i].charAt(j), (int) Math.pow(10, words[i].length() - j - 1));
                    continue;
                }

                map.put(words[i].charAt(j),
                        map.get(words[i].charAt(j)) + (int) Math.pow(10, words[i].length() - j - 1));
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((c1, c2) -> {
            return map.get(c2) - map.get(c1);
        });

        for (int i = 0; i < n; i++) {
            char value = '9';
            for (int j = 0; j < list.size(); j++) {
                words[i] = words[i].replace(list.get(j), value--);
            }
        }

        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(words[i]);
        }

        System.out.println(sum);
    }
}
