package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class  Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

//응급실
public class Main5_8 {

    public static int solution(int n, int m, int[] patients) {
        int pos = m;
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i : patients) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {

            int poll = queue.poll();

            if (poll >= Collections.max(queue)) { //위험도가 가장 높다면
                answer++;

                if (pos == 0) {
                    return answer;
                }

            } else {

                queue.offer(poll);

                if (pos == 0) {
                    pos = queue.size();
                }
            }

            pos--;
        }

        return answer;
    }

    public static int solution2(int n, int m, int[] patients) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, patients[i]));
        }

        while (!queue.isEmpty()) {
            Person temp = queue.poll();

            for (Person p : queue) {
                if (temp.priority < p.priority) {
                    queue.offer(temp);
                    temp = null;
                    break;
                }
            }

            if (temp != null) { //위험도가 가장 높다면
                answer++;
                if (temp.id == m) {
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] patients = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            patients[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, patients));

        br.close();
    }

}
