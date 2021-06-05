package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://developer-hm.tistory.com/57
public class Main1_11 {

    public  String mySolution(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 1; //반복 횟수
        char prev = 0; //반복 문자

        for (int i = 0; i < s.length(); i++) {
            //직전의 문자와 같은 문자라면
            if (prev == s.charAt(i)) {
                count++;
                continue;
            }

            //직전에 반복되는 문자가 있었다면, 문자의 개수를 문자열에 추가
            if (count > 1) {
                sb.append(count);
            }

            sb.append(s.charAt(i));
            prev = s.charAt(i);
            count = 1;
        }

        //마지막까지 반복된 문자가 있을 수 있기때문에
        if (count > 1) {
            sb.append(count);
        }

        return sb.toString();
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s+" "; //반복문의 마지막 i에서 i+1시에 예외 방지
        int count = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count += 1;
            } else {
                sb.append(s.charAt(i));
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Main1_11 T = new Main1_11();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(T.solution(s));

        br.close();
    }
}
