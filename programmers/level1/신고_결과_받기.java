package programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int len = id_list.length;
        Map<String, Integer> map = new HashMap<>(); //key: 이름, value: 해당 이름의 id_list 인덱스

        for(int i = 0; i < len; i++) {
            map.put(id_list[i], i);
        }

        int[] reportedCnt = new int[len]; //i번 유저의 신고 당한 횟수
        boolean[][] reportUser = new boolean[len][len]; //i번 유저를 신고한 사람들

        for(String s : report) {
            StringTokenizer st = new StringTokenizer(s);
            int from = map.get(st.nextToken());
            int to = map.get(st.nextToken());

            if(!reportUser[to][from]) {
                reportedCnt[to]++;
                reportUser[to][from] = true;
            }
        }

        for(int i = 0; i < len; i++) {
            if(reportedCnt[i] >= k) {
                for(int j = 0; j < len; j++) {
                    if(reportUser[i][j]) answer[j]++;
                }
            }
        }

        return answer;
    }
}
