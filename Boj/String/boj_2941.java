// 날짜 : 2020-10-26
// 출처 : https://www.acmicpc.net/problem/2941
// 풀이 : https://developer-hm.tistory.com/4
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        s = s.replace("c=", "1").replace("c-", "1").replace("dz=", "1").replace("d-", "1").replace("lj", "1")
                .replace("nj", "1").replace("s=", "1").replace("z=", "1");

        System.out.println(s.length());
    }
}
