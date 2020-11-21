package Programmers;

import java.time.LocalDate;

public class 2016년 {
    public String solution(int a, int b) {
        LocalDate date = LocalDate.of(2016,a,b);
        return date.getDayOfWeek().toString().substring(0,3);
    }
}
