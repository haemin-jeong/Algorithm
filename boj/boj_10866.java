package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10866 {
    static class Deque {
        int[] arr;
        int front = 0; //앞에 삽입할 위치
        int rear = 1; //뒤에 삽입할 위치
        int size = 0;

        public Deque(int n) {
            arr = new int[n];
        }

        public void pushFront(int x) {
            arr[front--] = x;
            size++;


            if (front <= -1) {
                front = arr.length - 1;
            }
        }

        public void pushBack(int x) {
            arr[rear++] = x;
            size++;

            if (rear >= arr.length) {
                rear = 0;
            }
        }

        public int popFront() {
            if (size == 0) {
                return -1;
            }

            if (front >= arr.length-1) {
                front = 0;
            } else {
                front++;
            }

            size--;

            return arr[front];
        }

        public int popBack() {
            if (size == 0) {
                return -1;
            }

            if (rear <= 0) {
                rear = arr.length-1;
            } else {
                rear--;
            }

            size--;

            return arr[rear];
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

            if (front >= arr.length-1) {
                return arr[0];
            }

            return arr[front+1];
        }

        public int back() {
            if (size == 0) {
                return -1;
            }

            if (rear <= 0) {
                return arr[arr.length-1];
            }

            return arr[rear-1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque deque = new Deque(n);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                deque.pushFront(x);
            } else if (command.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                deque.pushBack(x);
            } else if (command.equals("pop_front")) {
                sb.append(deque.popFront()).append("\n");
            } else if (command.equals("pop_back")) {
                sb.append(deque.popBack()).append("\n");
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(deque.empty()).append("\n");
            } else if (command.equals("front")) {
                sb.append(deque.front()).append("\n");
            } else if (command.equals("back")) {
                sb.append(deque.back()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
