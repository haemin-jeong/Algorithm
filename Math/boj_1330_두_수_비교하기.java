// Date : 2020-10-25
// Link : https://www.acmicpc.net/problem/1330

package Math;

import java.util.*;

public class boj_1330_두_수_비교하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > b)
            System.out.println(">");
        else if (a < b)
            System.out.println("<");
        else
            System.out.println("==");
    }
}