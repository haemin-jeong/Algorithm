package inflearn.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Brick implements Comparable<Brick>{
    int area;
    int height;
    int weight;

    public Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        return o.area - this.area;
    }
}

//가장 높은 탑 쌓기
public class Main10_4 {

    public static int solution(int n, Brick[] arr) {
        Arrays.sort(arr); //넓이를 기준으로 내림차순 정렬
        int answer = 0;
        int[] dy = new int[n];
        dy[0] = arr[0].height;
        answer = dy[0]; //dy[0]이 답일수도 있기 때문에 answer 초기화

        for (int i = 1; i < n; i++) {
            int max = 0;

            for (int j = i - 1; j >= 0; j--) {
                //넓이를 기준으로 내림차순으로 정렬되어 있기 때문에,
                //무게만 비교하면 벽돌을 쌓을 수 있는지 알 수 있다.
                if (arr[i].weight < arr[j].weight && dy[j] > max) {
                    max = dy[j];
                }
            }

            dy[i] = max + arr[i].height;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Brick[] arr = new Brick[n];

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr[i] = new Brick(area, height, weight);
        }

        System.out.println(solution(n, arr));

        br.close();
    }
}
