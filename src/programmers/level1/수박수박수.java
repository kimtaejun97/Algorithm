package programmers.level1;

public class 수박수박수 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        if(n<2) return "수";
        sb.append("수박".repeat(n/2)).append("수".repeat(n%2));

        return sb.toString();
    }
}
