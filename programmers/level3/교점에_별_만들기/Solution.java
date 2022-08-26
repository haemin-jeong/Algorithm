package programmers.level3.교점에_별_만들기;

import java.util.*;

class Solution {
    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxY = Integer.MIN_VALUE;

    public String[] solution(int[][] line) {
        List<Point> points = getPoints(line);

        int width = maxY - minY + 1;
        int height = maxX - minX + 1;

        char[][] board = new char[height][width];

        for(int i = 0; i < height; i++) {
            Arrays.fill(board[i], '.');
        }

        int plusY = minY >= 0 ? Math.negateExact(minY) : Math.abs(minY);
        int plusX = minX >= 0 ? Math.negateExact(minX) : Math.abs(minX);

        points.forEach(p -> {
            int x = p.x  + plusX;
            int y = p.y + plusY;
            board[x][y] = '*';
        });

        String[] answer = new String[height];

        for(int i = 0; i < height; i++) {
            answer[i] = String.valueOf(board[height  - 1 - i]);
        }

        return answer;
    }

    private List<Point> getPoints(int[][] line) {
        List<Point> points = new ArrayList<>();

        for(int i = 0; i < line.length; i++) {
            for(int j = i+1; j < line.length; j++) {
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];

                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                if(a * d - b * c == 0) {
                    continue;
                }

                if((b * f - e * d) % (a * d - b * c) != 0 || (e * c - a * f) % (a * d - b * c) != 0) {
                    continue;
                }

                int y = (int)((b * f - e * d) / (a * d - b * c));
                int x = (int)((e * c - a * f) / (a * d - b * c));

                minX = Math.min(minX , x);
                maxX = Math.max(maxX, x);

                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);

                points.add(new Point(x, y));
            }
        }

        return points;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}