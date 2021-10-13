package programmers.광탈방지Java;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationPointer = 0;

        int position = 1;
        while(position <= n){
            // 전 탐색지점 ~ 이번 탐색 지점 사이에 이미 설치된 기지국이 있다면 해당 기지국의 영향권 밖으로 이동.
            if(stationPointer < stations.length
                    && stations[stationPointer] - w <= position){
                position = stations[stationPointer++] + w + 1;
            }
            else{
                answer ++;

                // w 떨어진 곳에 기지국을 설치하고 포인터를 영향권 밖으로 옮김.
                position += 2*w + 1;
            }
        }
        return answer;
    }
}
