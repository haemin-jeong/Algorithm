package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        //정상에 올라간 후에는 미끄러지지 않기 때문에 막대 길이 v에서 마지막 날에 미끌어질 b를 미리 뺀 수를 하루에 올라가는 길이(a-b)로 나눈다.
        int day = (v-b) / (a-b);

        //나머지가 있는 경우 하루를 더 올라가야되는 것이기 때문에 하루를 더해준다.
        if ((v-b) % (a-b) > 0) {
            day++;
        }

        System.out.println(day);
    }
}
