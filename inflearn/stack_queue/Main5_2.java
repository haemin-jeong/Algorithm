package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호 문자 제거
public class Main5_2 {

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else if (c == ')')
                stack.pop();
            else {
                if (stack.isEmpty())
                    sb.append(c);
            }
        }

        return sb.toString();
    }

    //강의 풀이
    public static String solution2(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == ')') {
                while (stack.pop() != '(');
            } else
                stack.push(c);
        }

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(solution2(br.readLine()));
    }
}
