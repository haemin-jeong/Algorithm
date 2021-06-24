package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Player implements Comparable<Player>{
    int height;
    int weight;

    public Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Player o) {
        return o.height-height;
    }
}

//씨름 선수
public class Main9_1 {

    public static int solution(List<Player> players, int n) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        Collections.sort(players);

        for (Player p : players) {
            if (p.weight> max) {
                max = p.weight;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Player> players = new ArrayList<>();

        StringTokenizer st = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            players.add(new Player(height, weight));
        }

        System.out.println(solution(players, n));

        br.close();
    }
}
