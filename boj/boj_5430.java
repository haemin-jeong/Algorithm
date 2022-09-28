package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            sb.append(ac(commands, n, br.readLine())).append("\n");
        }

        System.out.println(sb);
    }

    static String ac(char[] commands, int n, String arrStr) {
        StringTokenizer st = new StringTokenizer(arrStr, "[],");
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int j = 0; j < n; j++) {
            ad.add(Integer.parseInt(st.nextToken()));
        }

        boolean isFront = true;

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == 'R') {
                isFront = !isFront;
            } else {
                if (ad.isEmpty()) {
                    return "error";
                }

                if (isFront) {
                    ad.pollFirst();
                } else {
                    ad.pollLast();
                }
            }
        }

        int size = ad.size();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size > 0) {
            if (isFront) {
                sb.append(ad.pollFirst());
                for (int i = 0; i < size - 1; i++) {
                    sb.append(",").append(ad.pollFirst());
                }
            } else {
                sb.append(ad.pollLast());
                for (int i = 0; i < size - 1; i++) {
                    sb.append(",").append(ad.pollLast());
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
