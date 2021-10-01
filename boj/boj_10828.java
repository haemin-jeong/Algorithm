package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10828 {

    static class Stack {
        int length;
        int cur = 0; //다음 push때 값이 저장될 위치
        int[] arr;

        public Stack(int length) {
            this.length = length;
            arr = new int[length];
        }

        public void push(int x) {
            arr[cur++] = x;
        }

        public int pop() {
            if (size() == 0) {
                return -1;
            }

            return arr[--cur];
        }

        public int size() {
            return cur;
        }

        public int empty() {
            if (size() == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        public int top() {
            if (size() == 0) {
                return -1;
            }

            return arr[cur - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack(n);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } else if (command.equals("pop")) {
                sb.append(stack.pop()).append("\n");
            } else if (command.equals("top")) {
                sb.append(stack.top()).append("\n");
            } else if (command.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(stack.empty()).append("\n");
            }

        }

        System.out.println(sb);
    }
}
