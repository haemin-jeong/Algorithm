package programmers.level3.베스트앨범;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        Map<String, Integer[]> songTop2 = new HashMap<>();
        Map<String, Integer> playCount = new HashMap<>();

        for(int i = 0; i < len; i++) {
            if(!songTop2.containsKey(genres[i])) {
                songTop2.put(genres[i], new Integer[2]);
            }

            playCount.put(genres[i], playCount.getOrDefault(genres[i], 0) + plays[i]);

            for(int j = 0; j < 2; j++) {
                if(songTop2.get(genres[i])[j] == null) {
                    songTop2.get(genres[i])[j] = i+1;
                    break;
                }

                if(plays[songTop2.get(genres[i])[j] - 1] < plays[i]) {
                    if(j == 0) songTop2.get(genres[i])[1] = songTop2.get(genres[i])[0];
                    songTop2.get(genres[i])[j] = i+1;
                    break;
                }
            }
        }

        List<String> list = new ArrayList<>(playCount.keySet());
        list.sort((s1, s2) -> playCount.get(s2) - playCount.get(s1));

        List<Integer> list2 = new ArrayList<>();

        for(String s : list) {
            for(int i = 0 ; i < 2; i++)
                if(songTop2.get(s)[i] != null) list2.add(songTop2.get(s)[i] - 1);
        }

        int[] answer = new int[list2.size()];

        for(int i = 0; i < list2.size(); i++) answer[i] = list2.get(i);

        return answer;
    }
}