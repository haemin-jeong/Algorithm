package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//송아지 찾기(BFS : 상태트리탐색)
public class Main7_8 {

    /**
     * @param s : 현수 위치
     * @param e : 송아지 위치
     * @return : 점프의 최소 횟수
     */
    public static int bfs(int s, int e) {
        int[] distance = {-1, 1, 5}; //한번의 점프로 이동하는 거리
        boolean[] checked = new boolean[10001]; //중복되는 좌표를 걸러내기위해(직선의 좌표 점은 1~10000)
        int level = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int n = q.poll();

                for (int j : distance) {
                    int n2 = n + j;

                    if (n2 == e) //이동거리가 송아지의 위치 e와 같다면
                        return level+1;

                    if (n2 >= 1 && n2 <= 10000 && !checked[n2]) {
                        checked[n2] = true;
                        q.offer(n2);
                    }
                }
            }

            level++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.println(bfs(s, e));
    }
}
