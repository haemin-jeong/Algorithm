package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//합이 같은 부분집합(DFS : 아마존 인터뷰)
public class Main8_1 {

    //전체 집합 원소의 총합
    static int total = 0;

    static int n;
    static String answer = "NO";

    //두 부분 집합의 합이 같을 떄, 나머지 메서드들을 실행하지 않도록하는 용도
    static boolean flag = false;

    /**
     * @param idx : 대상 원소의 배열 인덱스
     * @param sum : 현재까지 부분 원소의 합
     */
    public static void dfs(int idx, int sum, int[] arr) {
        if (flag)
            return;

        //부분집합의 합이 total 값의 절반을 넘어서면 이미 정답이 될 수 없다.
        if (sum > (total/2))
            return;

        if (idx == n) {
            //한 부분집합의 합이 total 값의 절반이면 두 부분집합의 합은 같다.
            //total/2 == sum 을 조건으로하면 total 값이 홀수일때도 나머지연산은 몫을 구하기 떄문에 사용할 수 없다
            //(예를 들어 total 값이 125일 경우 sum이 62이면 참이 되어버린다.)
            //나누기를 조건으로 사용하려면 total%2 == 0 && total/2 == sum 으로 사용하자.
            if ((total-sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(idx + 1, sum + arr[idx], arr); //해당 원소를 포함하는 경우
            dfs(idx + 1, sum, arr); //해당 원소를 포함하지 않는 경우
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        dfs(0, 0, arr);

        System.out.println(answer);
    }
}
