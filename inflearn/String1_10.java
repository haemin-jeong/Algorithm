package inflearn;

import java.util.ArrayList;
import java.util.List;

//https://developer-hm.tistory.com/56
public class String1_10 {

    public String mySolution(String s, char t) {
        List<Integer> pos = new ArrayList<>();
        //문자 t가 있는 위치를 찾는다.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                pos.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            //어떤 위치의 문자 t와 가장 가까운지 찾는다.
            int min = Math.abs(pos.get(0)-i);

            for (int j = 1; j < pos.size(); j++) {
                if (min > Math.abs(pos.get(j) - i)) {
                    min = Math.abs(pos.get(j) - i);
                }
            }

            sb.append(min).append(" ");
        }

        return sb.toString();
    }

    public int[] solution(String s, char t) {
        int[] retArr = new int[s.length()]; //거리 배열
        int p = 1000; //t와의 거리

        //좌측에 있는 가장 가까운 t로부터의 거리
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
            }

            retArr[i] = p;
        }

        //우측에 있는 가장 가까운 t로부터의 거리
        p = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
            }

            retArr[i] = Math.min(retArr[i], p); //좌측과 우측 어디 쪽의 t와 가까운지
        }

        return retArr;
    }
}
