package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_20056 {
    private static class Fireball {
        int r, c;
        int m; //질량
        int s; //속력
        int d; //방향

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    private static int n;
    private static List<Fireball> fireballList = new ArrayList<>();

    //파이어볼 이동 시에 같은 위치에 파이어볼이 몇개 있는지 확인 하기위한 용도
    private static List<Fireball>[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new List[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int mm = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireballList.add(new Fireball(r, c, mm, s, d));
        }

        for (int i = 0; i < k; i++) {
            command();
        }

        int answer = fireballList.stream().mapToInt(fb -> fb.m).sum();

        System.out.println(answer);
    }

    private static void command() {
        moveAllFireballs();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //같은 위치에 파이어 볼이 2개 이상있으면 합쳐서 4개로 나눈다.
                if (map[i][j].size() >= 2) {
                    divideFireballs(i, j);
                }
            }
        }

        clearMap();
    }

    /**
     * r,c 위치에는 2개 이상의 파이어볼이 있고, 여러 개의 파이어 볼을 합쳐서 나눈다.
     */
    private static void divideFireballs(int r, int c) {
        int sumM = 0;
        int sumS = 0;
        boolean isOdd = true;
        boolean isEven = true;

        List<Fireball> divideList = map[r][c];

        for (Fireball fireball : divideList) {
            sumM += fireball.m;
            sumS += fireball.s;

            if (isEven && fireball.d%2 != 0) isEven = false;
            if (isOdd && fireball.d%2 == 0) isOdd = false;

            fireballList.remove(fireball);
        }

        int nm = sumM/5;

        //질량이 0이면 소멸
        if (nm == 0) return;

        int ns = sumS / divideList.size();

        if (isOdd || isEven) {
            fireballList.add(new Fireball(r, c, nm, ns, 0));
            fireballList.add(new Fireball(r, c, nm, ns, 2));
            fireballList.add(new Fireball(r, c, nm, ns, 4));
            fireballList.add(new Fireball(r, c, nm, ns, 6));
        } else {
            fireballList.add(new Fireball(r, c, nm, ns, 1));
            fireballList.add(new Fireball(r, c, nm, ns, 3));
            fireballList.add(new Fireball(r, c, nm, ns, 5));
            fireballList.add(new Fireball(r, c, nm, ns, 7));
        }
    }

    /**
     * 1 <-> N 행, 1 <-> N 열이 서로 이어져있음을 고려하여 파이어볼들을 이동시킨다.
     */
    private static void moveAllFireballs() {
        for (Fireball fireball : fireballList) {
            int nr = (fireball.r + dx[fireball.d] * fireball.s) % n;
            int nc = (fireball.c + dy[fireball.d] * fireball.s) % n;

            fireball.r = nr > 0 ? nr : (nr + n);
            fireball.c = nc > 0 ? nc : (nc + n);

            map[fireball.r][fireball.c].add(fireball);
        }
    }

    private static void clearMap() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j].clear();
            }
        }
    }
}
