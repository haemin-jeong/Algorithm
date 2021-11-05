package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16234 {
    
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, l, r;

    public static void bfs(int[][] board, List<Pos> alliances, int x, int y) {
        Queue<Pos> q = new LinkedList<>();

        Pos temp = new Pos(x, y);
        addAlliance(alliances, q, temp);

        while (!q.isEmpty()) {
            Pos pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || check[nx][ny]) {
                    continue;
                }

                int difference = Math.abs(board[pos.x][pos.y] - board[nx][ny]);

                if (difference >= l && difference <= r) {
                    check[nx][ny] = true;
                    addAlliance(alliances, q, new Pos(nx, ny));
                }
            }
        }
    }

    /**
     * 연합에 pos 위치의 국가를 추가한다.
     */
    private static void addAlliance(List<Pos> alliances, Queue<Pos> q, Pos pos) {
        q.offer(pos);
        alliances.add(pos);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;

        while(true) {
            int count = 0; //days번째 날의 연합 개수

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!check[i][j]) {
                        check[i][j] = true;

                        List<Pos>  alliances = new ArrayList<>();
                        bfs(board, alliances, i, j);

                        //alliances 사이즈가 1이면 리스트에 (i,j)만 있는 것이기 때문에 연합이 이루어지지 않은 것
                        if (alliances.size() == 1) {
                            check[i][j] = false;
                            continue;
                        }

                        int num = getPopulation(board, alliances);

                        //인구 이동
                        movePopulation(board, alliances, num);

                        count++;
                    }
                }
            }

            //연합이 이루어지지않음 -> 인구 이동X -> days 출력 후 프로그램 종료
            if (count == 0) {
                System.out.println(days);
                return;
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(check[i], false);
            }

            days++;
        }

    }

    /**
     * 인구 이동
     */
    private static void movePopulation(int[][] board, List<Pos> alliances, int num) {
        for (Pos pos : alliances) {
            board[pos.x][pos.y] = num;
        }
    }

    /**
     * 인구 이동으로 인한 각 칸의 인구수를 구한다.
     */
    private static int getPopulation(int[][] board, List<Pos> alliances) {
        int sum = 0;
        for (Pos pos : alliances) {
            sum += board[pos.x][pos.y];
        }

        return sum/ alliances.size();
    }
}
