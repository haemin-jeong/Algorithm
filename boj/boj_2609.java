package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2609 {

    //유클리드 호제법으로 최대 공약수 구하기
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }

        return gcd(q, p%q);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int gcd = gcd(n1, n2);

        System.out.println(gcd);

        //최소 공배수(LCM) : n1*n2/GCD
        System.out.println(n1*n2/gcd);
    }
}
