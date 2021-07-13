package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//유효한 팰린드롬
public class Main1_8 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solution(s));

        br.close();
    }

    public static String solution(String s) {
        String str = s.toLowerCase().replaceAll("[^a-z]", "");
        String reverse = new StringBuilder(str).reverse().toString();

        if (str.equals(reverse))
            return "YES";
        else
            return "NO";
    }

}
