// 풀이 날짜 : 2020-11-16
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12969

package Programmers;

import java.util.Scanner;

public class 직사각형_별찍기 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
