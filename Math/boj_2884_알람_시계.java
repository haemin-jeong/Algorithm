// Date : 2020-10-25
// Link : https://www.acmicpc.net/problem/2884

package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.StringTokenizer;

public class boj_2884_알람_시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        LocalTime time = LocalTime.of(hour, minute).minusMinutes(45);

        System.out.printf("%d %d\n", time.getHour(), time.getMinute());
    }
}
