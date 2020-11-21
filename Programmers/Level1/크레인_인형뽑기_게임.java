// 날짜 : 2020-11-3
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/64061

package Programmers;

import java.util.*;

public class 크레인_인형뽑기_게임 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] == 0) {
                    continue;
                }

                if (!stack.empty() && stack.peek() == board[j][moves[i] - 1]) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(board[j][moves[i] - 1]);
                }

                board[j][moves[i] - 1] = 0;
                break;
            }
        }

        return answer;
    }

}
