// Date : 2020-10-25
// Link : https://www.acmicpc.net/problem/14681
package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_14681_사분면_고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if (x > 0 && y > 0)
            System.out.println(1);
        else if (x > 0 && y < 0)
            System.out.println(4);
        else if (x < 0 && y > 0)
            System.out.println(2);
        else
            System.out.println(3);
    }
}