package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class boj_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int sum = 0;

        //key : 값, value : 빈도수
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Arrays.sort(arr);

        //산술 평균 출력
        System.out.println(Math.round((double)sum / n));

        //중앙 값 출력
        System.out.println(arr[n/2]);

        //최빈수
        int max = map.values().stream().mapToInt(i -> i).max().getAsInt();

        //최빈수인 값만 필터링하고 오름차순으로 정렬한다.
        List<Integer> list = map.keySet().stream().filter(key -> map.get(key) == max).sorted().collect(Collectors.toList());

        //최빈 값 출력
        if (list.size() > 1) { //최빈수가 같은 값이 여러개이면 2번째로 작은 값을 출력한다.
            System.out.println(list.get(1));
        } else {
            System.out.println(list.get(0));
        }

        //범위 출력
        System.out.println(arr[n-1] - arr[0]);
    }
}
