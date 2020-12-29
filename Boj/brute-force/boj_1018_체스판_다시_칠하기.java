
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1018_체스판_다시_칠하기  {
    public static void main(String[] args) throws IOException {
        char[][] blackBoard = {
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        };

        char[][] whiteBoard = {
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[][] input =  new char[h][w];

        int result = h*w;
        
        for (int i = 0; i < h; i++) {
            input[i] = br.readLine().toCharArray();
        }
        
        for (int i = 0; i <= h-8; i++) {
            for (int j = 0; j <= w-8; j++) {

                int black = 0;
                int white = 0;
                int x;
                int y=0;

                for (int k = i; k < (i+8); k++) {
                    x = 0;
                    for (int l = j; l < (j+8); l++) {
                        if (input[k][l] != blackBoard[y][x])
                            black++;

                        if (input[k][l] != whiteBoard[y][x])
                            white++;
                        x++;
                    }
                    y++;
                }

                int temp = Math.min(black, white);
                if (temp < result)
                    result = temp;
            }
        }

        System.out.println(result);
    }
}
