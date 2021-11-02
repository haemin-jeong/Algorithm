package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15686 {

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Pos> chickens = new ArrayList<>();
    static List<Pos> homes = new ArrayList<>();
    static int[] combi;
    static int n, m;
    static int answer = Integer.MAX_VALUE;

    public static void dfs(int level, int start) {
        if (level == m) {
            int sum = 0;

            for (Pos home : homes) {
                int min = Integer.MAX_VALUE;

                for (int i : combi) {
                    Pos chicken = chickens.get(i);
                    min = Math.min(min, Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y));
                }

                sum += min;

                if (sum > answer) {
                    return;
                }
            }

            answer = Math.min(answer, sum);
        } else {
            for (int i = start; i < chickens.size(); i++) {
                combi[level] = i;
                dfs(level+1, i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        combi = new int[m];

        int[][] board = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 1) {
                    homes.add(new Pos(i,j));
                } else if (board[i][j] == 2) {
                    chickens.add(new Pos(i, j));
                }
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }
}
