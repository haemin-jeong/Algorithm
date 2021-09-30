package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isVPS = false;
                        break;
                    }

                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                isVPS = false;
            }

            sb.append(isVPS ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
