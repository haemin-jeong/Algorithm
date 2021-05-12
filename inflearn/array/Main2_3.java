package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가위바위보
public class Main2_3 {

    public static char[] solution(int n, int[] a, int[] b) {

        char[] retArr = new char[n];

        for (int i = 0; i < n; i++) {

            if (a[i] == b[i]) {
                retArr[i] = 'D';
            } else if ((a[i] == 1 && b[i] == 3) || (a[i] == 2 && b[i] == 1) || (a[i] == 3 && b[i] == 2)) {
                retArr[i] = 'A';
            } else {
                retArr[i] = 'B';
            }
        }

        return retArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        char[] chars = solution(n, a, b);

        for (char c : chars) {
            System.out.println(c);
        }
    }
}
