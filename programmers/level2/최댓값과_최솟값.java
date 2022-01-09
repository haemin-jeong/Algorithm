package programmers.level2;

import java.util.StringTokenizer;

public class 최댓값과_최솟값 {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());

            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return min + " " + max;
    }
}
