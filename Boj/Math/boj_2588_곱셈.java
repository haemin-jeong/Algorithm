// Date : 2020-10-19
// Link : https://www.acmicpc.net/problem/2588

package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2588_곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());

        int n3 = n1 * (n2 % 10);
        int n4 = n1 * (n2 % 100 / 10);
        int n5 = n1 * (n2 / 100);
        int n6 = n3 + n4 * 10 + n5 * 100;

        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
        System.out.println(n6);
    }
}
