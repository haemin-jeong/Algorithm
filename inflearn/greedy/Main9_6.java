package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//친구인가?(Disjoint-set : union&find)
public class Main9_6 {
    //서로소 집합을 표현. 배열의 인덱스는 학생번호, 값은 집합의 번호
    static int[] unf;

    //v번 학생의 집합 번호를 리턴
    public static int find(int v) {
        if (unf[v] == v)
            return v;
        else
            return unf[v] = find(unf[v]); //경로 단축
    }

    //두 학생을 같은 집합으로
    public static void union(int v1, int v2) {
        int f1 = find(v1);
        int f2 = find(v2);

        if (f1 != f2)
            unf[f1] = f2;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //반 학생수
        int m = Integer.parseInt(st.nextToken()); //숫자쌍 개수

        unf = new int[n+1];

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            union(f1, f2);
        }

        st = new StringTokenizer(br.readLine());

        int t1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());



        if (find(t1) == find(t2))
            System.out.println("YES");
        else
            System.out.println("NO");

        br.close();
    }
}
