package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1966 {

    //문서의 순서와 우선순위를 알고 있어야되기 때문에 클래스로 만들었다.
    static class Document {
        int order;
        int priority;

        public Document(int order, int priority) {
            this.order = order;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numOfTestCase; i++) {
            Queue<Document> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //문서의 개수
            int m = Integer.parseInt(st.nextToken()); //큐에서의 문서 위치

            int maxPriority = Integer.MIN_VALUE; //큐에 있는 문서의 가장 높은 우선순위 값

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                maxPriority = Math.max(maxPriority, priority);
                q.offer(new Document(j, priority));
            }

            int mOrder = getPrintOrder(q, m, maxPriority);
            sb.append(mOrder).append("\n");
        }

        System.out.println(sb);
    }

    /**
     * @param m 문서 위치
     * @return 문서 위치 m의 출력 순서
     */
    private static int getPrintOrder(Queue<Document> q, int m, int maxPriority) {
        int count = 0; //인쇄 순서

        while(!q.isEmpty()) {
            Document doc = q.poll();

            //우선순위가 maxPriority보다 낮으면 다시 큐에 넣는다.
            if (doc.priority < maxPriority) {
                q.offer(doc);
            } else {
                count++;

                if (doc.order == m) {
                    return count;
                }

                //꺼낸 문서의 중요도가 maxPriority보다 높거나 같으면 큐에 남아있는 문서들 중 maxPriority를 알 수 없기 때문에 다시 계산해야한다.
                maxPriority = q.stream().mapToInt(d -> d.priority).max().getAsInt();
            }
        }

        return -1;
    }
}
