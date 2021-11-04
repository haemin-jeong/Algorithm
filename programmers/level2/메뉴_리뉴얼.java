package programmers.level2;

import java.util.*;

public class 메뉴_리뉴얼 {
    List<Character> menuList;
    List<List<String>> courseCountList;
    List<String> result = new ArrayList<>();
    String[] orders;
    int[] combi;

    public void dfs(int level, int start) {
        if(level == combi.length) {
            //해당 조합 메뉴들을 주문한 손님 수
            int count = 0;

            for(String o : orders) {
                boolean flag = true;

                for(int i : combi) {
                    if(o.indexOf(menuList.get(i)) == -1) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    count++;
                }
            }

            //해당 조합 메뉴들을 주문한 손님 수가 2명이상이면
            if(count >= 2) {
                StringBuilder sb = new StringBuilder();

                for(int i : combi) {
                    sb.append(menuList.get(i));
                }

                courseCountList.get(count).add(sb.toString());
            }
        } else {
            for(int i = start; i < menuList.size(); i++) {
                combi[level] = i;
                dfs(level+1, i+1);
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {
        this.orders = orders;
        Set<Character> set = new HashSet<>();

        for(String o : orders) {
            for(char c : o.toCharArray()) {
                set.add(c);
            }
        }

        menuList = new ArrayList<>(set);

        for(int i : course) {
            combi = new int[i];

            /*
            인덱스 : 주문한 손님 수
            값 : 인덱스 명이 주문한 메뉴 조합 리스트
             */
            courseCountList = new ArrayList<>();

            for(int j = 0 ; j <= orders.length; j++) {
                courseCountList.add(new ArrayList<>());
            }

            dfs(0, 0);

            //리스트의 인덱스가 주문한 손님의 수이기 떄문에 리스트를 역순으로 탐색하여 가장 많은 손님이 주문한 i개의 메뉴 조합들을 추가한다.
            for(int j = orders.length-1; j >= 0; j--) {
                if(!courseCountList.get(j).isEmpty()) {
                    for(String s : courseCountList.get(j)) {
                        result.add(s);
                    }

                    break;
                }
            }
        }

        Collections.sort(result);
        String[] answer = new String[result.size()];

        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
