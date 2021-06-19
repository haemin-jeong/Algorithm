package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Question {
    int score;
    int time;

    public Question(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

//최대점수 구하기(DFS)
public class Main8_3 {

    static int answer = 0;
    static int m, n;

    public static void dfs(int level, int totalScore, int totalTime, Question[] arr) {
        if (totalTime > m)
            return;

        if (level == n) {
            answer = Math.max(totalScore, answer);
        } else {
            dfs(level+1, totalScore+arr[level].score, totalTime+arr[level].time, arr);
            dfs(level+1, totalScore, totalTime, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Question[] arr = new Question[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            arr[i] = new Question(score, time);
        }

        dfs(0, 0, 0, arr);

        System.out.println(answer);
    }
}
