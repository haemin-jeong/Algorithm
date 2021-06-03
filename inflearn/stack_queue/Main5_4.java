package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//후위식 연산(postfix)
public class Main5_4 {

    //숫자면 스택에 넣고, 연산자면 스택에서 두개를 꺼내서 연산하고 연산 결과를 스택에 넣는다.
    public static int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();

                if (c == '+')
                    stack.push(num2 + num1);
                else if (c == '-')
                    stack.push(num2 - num1);
                else if (c == '*')
                    stack.push(num2 * num1);
                else
                    stack.push(num2 / num1);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
