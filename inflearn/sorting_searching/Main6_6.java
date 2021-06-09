package inflearn.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//장난 꾸러기
public class Main6_6 {

    public static List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>(2);
        int[] copy = Arrays.copyOf(arr, n);
        Arrays.sort(copy);

        for (int i = 0; i < n; i++) {
            if (arr[i] != copy[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (Integer i : solution(n, arr)) {
            System.out.print(i + " ");
        }

        br.close();
    }
}
