package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)
public class Main8_14 {

    static Point[] combination;
    static int n, m, len, answer = Integer.MAX_VALUE;
    static List<Point> pizza, home;

    //조합 구하기
    public static void dfs(int level, int start) {
        if (level == m) {
            int sum = 0;
            for (Point hp : home) {
                int minDistance = Integer.MAX_VALUE;

                for (Point pp : combination) {
                    minDistance = Integer.min(minDistance, Math.abs(hp.x - pp.x) + Math.abs(hp.y - pp.y));
                }

                sum += minDistance;
            }

            answer = Math.min(answer, sum);
        } else {
            for (int i = start; i < len; i++) {
                combination[level] = pizza.get(i);
                dfs(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pizza = new ArrayList<>();
        home = new ArrayList<>();
        combination = new Point[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == 1)
                    home.add(new Point(i, j));
                else if(temp == 2)
                    pizza.add(new Point(i, j));
            }
        }

        len = pizza.size();

        dfs(0, 0);

        System.out.println(answer);

        br.close();
    }
}
