package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //상근이 카드수

        //key : 카드, value : 카드 개수
        Map<Integer, Integer> cardMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            cardMap.put(card, cardMap.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            //cardMap.getOrDefault : num번 카드가 있으면 카드 개수 반환, 없으면 0 반환
            sb.append(cardMap.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb);
    }
}
