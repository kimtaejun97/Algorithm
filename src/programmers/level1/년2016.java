package programmers.level1;

public class 년2016 {

    public String solution(int a, int b) {
        int[] monthDay = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};

        int day = 0;
        for(int i=1; i<a; i++) day+= monthDay[i];
        day += b - 1;

        return dayOfWeek[day % 7];
    }

}
