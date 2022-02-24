package boj;//풀이 날짜 : 2020-12-24
//문제 출처 : https://www.acmicpc.net/problem/2798

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2798 {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numOfCard = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < numOfCard; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution(list, numOfCard, sum));
    }

    private static int solution(List<Integer> list, int numOfCard, int sum) {
        int max = 0;
        for (int i = 0; i < numOfCard -2; i++) {
            
            for (int j = i+1; j < numOfCard -1; j++) {

                for (int k = j+1; k < numOfCard; k++) {
                    int result = list.get(i) + list.get(j) + list.get(k);

                    if (result == sum) {
                        return result;
                    }

                    if (result < sum && result > max) {
                        max = result;
                    }
                }
            }
        }

        return max;
    }

}
