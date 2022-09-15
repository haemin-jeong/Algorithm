package programmers;

import java.util.Arrays;

public class 여행경로 {

    boolean[] visited;
    String[] answer;
    String[][] tickets;
    boolean flag = false;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new String[tickets.length+1];
        this.tickets = tickets;

        Arrays.sort(tickets, (t1, t2) -> t1[1].compareTo(t2[1]));

        answer[0] = "ICN";
        dfs(0, "ICN");

        return answer;
    }

    void dfs(int level, String from) {
        if(flag) return;

        answer[level] = from;

        if(level == tickets.length) {
            flag = true;
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(from)) {
                visited[i] = true;
                dfs(level + 1, tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}
