package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//교육과정 설계
public class Main5_7 {

    public static String solution(String required, String subjects) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : required.toCharArray()) {
            queue.offer(c);
        }

        for (char c : subjects.toCharArray()) {
            if (queue.contains(c)) {
                if (queue.poll() != c) { //교육과정에 과목이 포함되어있지만, 순서가 다르다면
                    return "NO";
                }
            }
        }

        if (queue.isEmpty()) {
            return "YES";
        } else { //필수 과목중 교육과정에 포함되지 않는 과목이 있을때
            return "NO";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String required = br.readLine();
        String subjects = br.readLine();

        System.out.println(solution(required, subjects));

        br.close();
    }
}
