// Date : 2020-10-17
// Link : https://www.acmicpc.net/problem/10162

package Greedy;

import java.util.Scanner;

public class boj_10162_전자레인지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int a= 0, b= 0, c = 0;

        a = time/(5*60);
        time = time%(5*60);

        b = time/60;
        time = time%60;

        c = time/10;

        if (time%10 != 0) {
            System.out.println(-1);
        } else {
            System.out.printf("%d %d %d \n", a, b, c);
        }
    }  
}
