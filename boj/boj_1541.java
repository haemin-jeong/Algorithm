package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int answer = 0;
        StringTokenizer addSt = new StringTokenizer(st.nextToken(), "+");
        while (addSt.hasMoreTokens()) {
            answer += Integer.parseInt(addSt.nextToken());
        }

        while (st.hasMoreTokens()) {
            addSt = new StringTokenizer(st.nextToken(), "+");
            while (addSt.hasMoreTokens()) {
                answer -= Integer.parseInt(addSt.nextToken());
            }
        }

        System.out.println(answer);
    }
}
