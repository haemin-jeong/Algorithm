package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int pushNum = 1; //스택에 담을 수

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine()); //i번째 수열 원소

            //스택의 마지막 원소가 i번째 수열 원소가 될 때까지 스택에 PUSH
            while (num >= pushNum) {
                stack.push(pushNum++);
                sb.append("+").append("\n");
            }

            //스택의 마지막 원소가 i번째 수열 원소가 아니라면 실패
            if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }

            //스택의 마지막 원소가 i번째 수열 원소와 일치하다면 POP
            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}
