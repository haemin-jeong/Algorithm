package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//회문 문자열
public class Main1_7 {

    public static String solution(String s) {
        s = s.toUpperCase();
        String reverse = new StringBuilder(s).reverse().toString();

        if (s.equals(reverse))
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
        br.close();
    }
}
