package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //wheel[i][j] : i번쨰 바퀴의 j번째 톱니바퀴
        //j : 0 -> 12시방향 톱니바퀴, 4 -> 6시방향 톱니바퀴
        int[][] wheels = new int[5][8];

        for (int i = 1; i <= 4; i++) {
            String s = br.readLine();

            for(int j = 0; j < 8; j++) {
                wheels[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            //0: 회전X, 1: 시계 방향, -1: 반시계 방향
            int[] directions = getDirections(wheels, num, dir);

            for (int j = 1; j <= 4; j++) {
                if(directions[j] != 0) {
                    //i번째 바퀴를 회전시킨다.
                    rotate(wheels[j], directions[j]);
                }
            }
        }

        int answer = getScore(wheels);

        System.out.println(answer);
    }

    /**
     * 톱니바퀴의 점수 합을 구한다.
     */
    private static int getScore(int[][] wheels) {
        int answer = 0;
        int score = 1;

        for (int i = 1; i <= 4; i++) {
            if (wheels[i][0] == 1) {
                answer += score;
            }

            score *= 2;
        }
        return answer;
    }

    /**
     * 1~4번 바퀴들의 회전 방향을 구한다.
     * @param num 회전시키는 바퀴 번호
     * @param dir num번 바퀴의 회전 방향
     * @return 1~4 바퀴들의 회전 방향
     */
    private static int[] getDirections(int[][] wheels, int num, int dir) {
        //0: 회전X, 1: 시계 방향, -1: 반시계 방향
        int[] directions = new int[5];
        directions[num] = dir;

        //회전 시킬 바퀴를 기준으로 왼쪽 바퀴들의 회전 여부와 방향을 구한다.
        for (int j = num; j > 1; j--) {
            //맞닿은 극이 같은 경우 다음 바퀴는 회전하지 않기 때문에
            //나머지 바퀴들의 회전방향도 구하지 않아도 된다.
            if (wheels[j][6] ==  wheels[j-1][2]) {
                break;
            }

            directions[j-1] = directions[j] * -1;
        }

        //회전 시킬 바퀴를 기준으로 오른쪽 바퀴들의 회전 여부와 방향을 구한다.
        for (int j = num; j < 4; j++) {
            //맞닿은 극이 같은 경우 다음 바퀴는 회전하지 않기 때문에
            //나머지 바퀴들의 회전방향도 구하지 않아도 된다.
            if (wheels[j][2] == wheels[j+1][6]) {
                break;
            }

            directions[j+1] = directions[j] * -1;
        }
        return directions;
    }

    /**
     * wheel 바퀴를 dir 방향으로 회전시킨다.
     * @param dir 1: 시계 방향 회전, -1: 반시계 방향 회전
     */
    private static void rotate(int[] wheel, int dir) {
        if (dir == 1) {
            int temp = wheel[7];

            for (int i = 7; i > 0; i--) {
                wheel[i] = wheel[i-1];
            }

            wheel[0] = temp;
        } else if (dir == -1) {
            int temp = wheel[0];

            for (int i = 0; i < 7; i++) {
                wheel[i] = wheel[i+1];
            }

            wheel[7] = temp;
        }
    }
}
