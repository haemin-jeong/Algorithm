package inflearn.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Question {
    int time;
    int score;

    public Question(int time, int score) {
        this.time = time;
        this.score = score;
    }
}

//최대점수 구하기(냅색 알고리즘)
public class Main10_6 {

    public static int solution(int n, int m, List<Question> questions) {
        int[] dy = new int[m+1];

        for (int i = 0; i < n; i++) {

            Question question = questions.get(i);

            for (int j = m; j >= question.time; j--) {
                dy[j] = Math.max(dy[j], dy[j - question.time] + question.score);
            }
        }

        return dy[m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            questions.add(new Question(time, score));
        }

        System.out.println(solution(n, m, questions));

        br.close();
    }
}
