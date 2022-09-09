package programmers.kakao;

public class 광고_삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int len = convertSeconds(play_time);
        int[] check = new int[len+2];

        for(String log : logs) {
            String[] s = log.split("-");
            int start = convertSeconds(s[0]);
            int end = convertSeconds(s[1]) - 1;
            check[start]++; check[end + 1]--;
        }

        int plusNum = 0;
        int[] prefixSum = new int[len+1];
        for(int i = 0; i <= len; i++) {
            plusNum += check[i];
            prefixSum[i] = plusNum;
        }

        int advLen = convertSeconds(adv_time);
        long curSum = 0;
        for(int i = 0; i <= advLen; i++) {
            curSum += prefixSum[i];
        }

        int start = 1;
        long maxSum = curSum;
        int time = 0;
        for(int end = advLen+1; end <= len; end++) {
            curSum -= prefixSum[start - 1];
            curSum += prefixSum[end - 1];

            if(maxSum < curSum) {
                maxSum = curSum;
                time = start;
            }

            start++;
        }

        int seconds = time % 60; time /= 60;
        int minutes = time % 60;
        int hour = time / 60;

        return buildTimeStr(hour, minutes, seconds);
    }

    int convertSeconds(String timeStr) {
        String[] time = timeStr.split(":");
        return Integer.parseInt(time[0]) * 60 * 60 + Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
    }

    String buildTimeStr(int hour, int minutes, int seconds) {
        StringBuilder sb = new StringBuilder();
        sb.append(hour < 10 ? "0" : "");
        sb.append(hour);
        sb.append(":");
        sb.append(minutes < 10 ? "0" : "");
        sb.append(minutes);
        sb.append(":");
        sb.append(seconds < 10 ? "0" : "");
        sb.append(seconds);
        return sb.toString();
    }
}
