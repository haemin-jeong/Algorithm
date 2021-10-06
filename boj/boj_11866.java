package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        //StringBuilder를 사용하여 한번에 모아 출력함으로써 실행 시간 단축
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {

            //k-1번째 수까지는 큐에서 빼고 다시 뒤로 넣음으로써 원과 같이 순환하는 형태로 만든다.
            for (int i = 0; i < k-1; i++) {
                queue.offer(queue.poll());
            }

            //k번째 수는 큐에서 빼서 순열의 원소로 넣는다.
            sb.append(queue.poll());

            //큐의 사이즈가 0이면 순열의 끝이기 때문에 , 을 붙히지 않고 >을 붙혀야 한다.
            if (queue.size() != 0) {
                sb.append(", ");
            }

        }

        sb.append(">");

        System.out.println(sb);
    }
}
