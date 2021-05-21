package inflearn.tow_pointers_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
두 배열 합치기
합쳐서 정렬하는 것은 인상적이지 못하다. 투 포인터 알고리즘으로 포인터 두개 잡아서 효율적을 짤 수 있냐를 묻는 문제
시간 복잡도 : 퀵정렬 O(nlogn) -> two pointers 알고리즘 O(n)
*/
public class Main3_1 {

    public static int[] solution(int n, int[] arr1, int m, int[] arr2) {
        int[] arr = new int[n + m];

        for (int i = 0; i < n; i++) {
            arr[i] = arr1[i];
        }

        for (int i = 0; i < m; i++) {
            arr[n++] = arr2[i];
        }

        Arrays.sort(arr);

        return arr;
    }

    //two pointers 알고리즘
    public static List<Integer> solution2(int n, int[] arr1, int m, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int p1 = 0, p2 = 0; //두개의 포인터

        while (p1 < n && p2 < m) { //두 배열 모두 끝이 아니라면
            // 오름차순 정렬이이 때문에 작은 수를 먼저 넣는다.
            if (arr1[p1] < arr2[p2])
                list.add(arr1[p1++]);
            else
                list.add(arr2[p2++]);
        }

        //두 배열 중 어떤 배열의 원소가 남은지를 모르기 때문에 반복문 두개 모두 실행
        //남은 수들을  리스트에 순차적으로 넣어준다.

        while (p1 < n) {
            list.add(arr1[p1++]);
        }

        while (p2 < m) {
            list.add(arr2[p2++]);
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : solution(n, arr1, m, arr2)) {
            System.out.print(i + " ");
        }
    }
}
