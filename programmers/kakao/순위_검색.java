package programmers.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 순위_검색 {
    Map<String, List<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();

        for(String s : info) {
            combiDfs(0, s.split(" "), "");
        }

        for(List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];

        for(int i = 0; i < query.length; i++) {
            StringTokenizer st = new StringTokenizer(query[i].replaceAll(" and ", ""));
            String key = st.nextToken();

            if(!map.containsKey(key)) {
                continue;
            }

            int targetScore = Integer.parseInt(st.nextToken());
            int index = lowerBound(targetScore, map.get(key));

            answer[i] = map.get(key).size() - index;
        }

        return answer;
    }

    int lowerBound(int target, List<Integer> list) {
        int start = 0;
        int end = list.size();
        int mid = (end - start) / 2;

        while(end > start) {
            mid = (start + end) / 2;

            if(list.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    void combiDfs(int level, String[] apply, String key) {
        if(level == 4) {
            if(!map.containsKey(key.toString())) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(Integer.parseInt(apply[4]));
            return;
        }

        combiDfs(level+1, apply, key + "-");
        combiDfs(level+1, apply, key + apply[level]);
    }
}
