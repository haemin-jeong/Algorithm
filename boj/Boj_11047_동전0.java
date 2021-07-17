// Date : 2020-10-11
// Link :  https://www.acmicpc.net/problem/11047

package boj;

import java.util.*;

public class Boj_11047_동전0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);

        for (int i = n - 1; i >= 0; i--) {
            cnt += k / coins[i];
            k = k % coins[i];
        }

        System.out.println(cnt);
    }
}
