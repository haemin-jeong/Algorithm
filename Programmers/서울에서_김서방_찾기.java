//날짜 : 2020-11-12
//출처 : https://programmers.co.kr/learn/courses/30/lessons/12919

package Programmers;

public class 서울에서_김서방_찾기 {
    public String solution(String[] seoul) {
        int n = 0;

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                n = i;
            }
        }

        return "김서방은 " + n + "에 있다";
    }
}
