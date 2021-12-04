package programmers.level1;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;

        for(int[] size : sizes) {
            if(size[0] < size[1]) {
                maxW = Math.max(maxW, size[1]);
                maxH = Math.max(maxH, size[0]);
            } else {
                maxW = Math.max(maxW, size[0]);
                maxH = Math.max(maxH, size[1]);
            }
        }

        return maxW * maxH;
    }
}
