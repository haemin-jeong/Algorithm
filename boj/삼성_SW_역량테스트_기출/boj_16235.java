package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16235 {
    static class Tree implements Comparable<Tree> {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n+1][n+1];
        int[][] a = new int[n+1][n+1];
        LinkedList<Tree> trees = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = 5;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            trees.offer(new Tree(x, y, z));
        }

        Collections.sort(trees);

        List<Tree> deathTrees = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            //spring
            int size = trees.size();
            for (int j = 0; j < size; j++){
                Tree t = trees.pollFirst();

                if (board[t.x][t.y] >= t.age) {
                    board[t.x][t.y] -= t.age;
                    t.age++;
                    trees.offerLast(t);
                } else {
                    deathTrees.add(t);
                }
            }

            //summer
            for (Tree dt : deathTrees) {
                board[dt.x][dt.y] += dt.age/2;
            }

            deathTrees.clear();

            //autumn
            List<Tree> newTrees = new ArrayList<>();
            size = trees.size();
            for (int j = 0; j < size; j++) {
                Tree t = trees.pollFirst();
                trees.offerLast(t);

                if (t.age % 5 == 0) {
                    for (int l = 0; l < 8; l++) {
                        int nx = t.x + dx[l];
                        int ny = t.y + dy[l];

                        if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                            newTrees.add(new Tree(nx, ny, 1));
                        }
                    }
                }
            }

            for (Tree nt : newTrees) {
                trees.offerFirst(nt);
            }

            //winter
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= n; l++) {
                    board[j][l] += a[j][l];
                }
            }
        }

        System.out.println(trees.size());
    }
}
