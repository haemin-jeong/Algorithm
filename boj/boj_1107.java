package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1107 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if (n == 100) {
            System.out.println(0);
            return;
        }

        boolean[] isBrokenNum = new boolean[10];

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int brokenNum = Integer.parseInt(st.nextToken());
                isBrokenNum[brokenNum] = true;
            }
        }

        int minCount = Math.abs(100 - n);
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            boolean isAvailableNum = true;
            for (char c : s.toCharArray()) {
                if (isBrokenNum[Character.getNumericValue(c)]) {
                    isAvailableNum = false;
                    break;
                }
            }

            if (isAvailableNum) {
                minCount = Math.min(minCount, s.length() + Math.abs(i - n));
            }
        }

        System.out.println(minCount);
    }
}
