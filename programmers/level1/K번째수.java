// 날짜 : 2020-11-5
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/42748

package programmers.level1;

import java.util.*;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int arr[] = new int[commands[i][1] - commands[i][0] + 1];

            System.arraycopy(array, commands[i][0] - 1, arr, 0, arr.length);

            Arrays.sort(arr);

            answer[i] = arr[commands[i][2] - 1];
        }

        return answer;
    }
}
