package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10845 {

    //링버퍼로 큐 구현
    static class Queue {
        private int[] arr;
        private int size = 0;
        private int front = 0;
        private int rear = 0;

        public Queue(int n) {
            arr = new int[n];
        }

        public void push(int x) {
            arr[rear++] = x;

            if (rear >= arr.length) {
                rear = 0;
            }

            size++;
        }

        public int pop() {
            if (rear == front) {
                return -1;
            }

            int data = arr[front++];

            if (front >= arr.length) {
                front = 0;
            }

            size--;

            return data;
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size == 0 ? 1 : 0;
        }

        public int front() {
            if (size == 0) {
                return -1;
            }

            return arr[front];
        }

        public int back() {
            if (size == 0) {
                return -1;
            }

            if (rear == 0) {
                return arr[arr.length-1];
            } else {
                return arr[rear-1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue queue = new Queue(n);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                queue.push(x);
            } else if (command.equals("pop")) {
                sb.append(queue.pop()).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(queue.empty()).append("\n");
            } else if (command.equals("front")) {
                sb.append(queue.front()).append("\n");
            } else if (command.equals("back")) {
                sb.append(queue.back()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
