package inflearn.tow_pointers_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//공통원소 구하기(two pointers 알고리즘)
public class Main3_2 {

    public static List<Integer> solution(int n, int[] nArr, int m, int[] mArr) {
        List<Integer> result = new ArrayList<>();
        int nPos = 0, mPos = 0;

        Arrays.sort(nArr);
        Arrays.sort(mArr);

        while (nPos < n && mPos < m) {

            if (nArr[nPos] < mArr[mPos]) {
                 nPos++;
            } else if (nArr[nPos] > mArr[mPos]) {
                mPos++;
            } else {
                result.add(nArr[nPos]);
                nPos++;
                mPos++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = solution(n, nArr, m, mArr);
        for (Integer i : list) {
            System.out.print(i + " ");
        }

        br.close();
    }
}
