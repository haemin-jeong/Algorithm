// Date : 2020-10-12
// Link : https://www.acmicpc.net/problem/5585

package Greedy;

import java.util.*;

public class Boj_5585_거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 1000 - sc.nextInt();
        int cnt = 0;

        cnt += money / 500;
        money = money % 500;

        cnt += money / 100;
        money = money % 100;

        cnt += money / 50;
        money = money % 50;

        cnt += money / 10;
        money = money % 10;

        cnt += money / 5;
        money = money % 5;

        cnt += money;

        System.out.println(cnt);
    }
}
