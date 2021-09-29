package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //StringBuilder를 사용하여 한번에 모아 출력함으로 실행시간 단축
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            //입력 종료 조건
            if (s.equals(".")) {
                break;
            }

            Stack<Character> stack =new Stack<>();
            boolean isBalance = true;

            for (char c : s.toCharArray()) {

                //여는 괄호이면 스택에 넣는다.
                if (c == '(' || c == '[') {
                    stack.push(c);
                }

                if (c == ')') {
                    //닫는 ) 괄호인데 스택이 비어있거나 pop한 값이 ( 이 아니면 균형이 맞지 않는 문자열
                    if (stack.isEmpty() || stack.pop() != '('){
                        isBalance = false;
                        break;
                    }
                }

                if (c == ']') {
                    //닫는 ] 괄호인데 스택이 비어있거나 pop한 값이 [ 이 아니면 균형이 맞지 않는 문자열
                    if (stack.isEmpty() || stack.pop() != '['){
                        isBalance = false;
                        break;
                    }
                }
            }

            //탐색이 종료되었지만, 스택이 비어있지 않다면 괄호 짝이 맞지 않아 균형이 맞지 않는 문자열
            if (!stack.isEmpty()) {
                isBalance = false;
            }

            sb.append(isBalance ? "yes" : "no").append("\n");
        }

        System.out.println(sb);
    }
}
