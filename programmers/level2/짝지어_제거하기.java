package programmers.level2;

import java.util.Stack;

public class 짝지어_제거하기 {

    public int solution(String s) {
        //문자열 길이가 홀수인 경우 짝지 맞지 않기 때문에 성공할 수 없다.
        if(s.length()%2 != 0) return 0;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++) {
            if(stack.size() > 0 && stack.peek() == s.charAt(i))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }
}
