package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            System.out.print(Integer.parseInt(st.nextToken()) - l*p + " ");
        }
    }
}
