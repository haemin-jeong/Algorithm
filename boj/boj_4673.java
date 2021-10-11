package boj;

import java.util.Arrays;

public class boj_4673 {
    public static void main(String[] args) {
        boolean[] isSelfNumber = new boolean[10001];
        Arrays.fill(isSelfNumber, true);

        //1~10000 범위에서 d(i)를 찾는다.
        for (int i = 1; i <= 10000; i++) {
            int dn = i;
            int num = i;

            //자리수를 분해해서 더한다.
            while(num > 0) {
                dn += num%10;
                num = num/10;
            }

            if (dn <= 10000) {
                //d(n)은 셀프 넘버가 아니다.
                isSelfNumber[dn] = false;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10000; i++) {
            if (isSelfNumber[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
