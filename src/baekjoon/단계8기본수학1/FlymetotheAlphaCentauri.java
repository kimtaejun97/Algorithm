package baekjoon.단계8기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
count  d  max
  1    1   1
  2    2   1
  3    4   2
  4    6   2
  5    9   3
  6   12   3
  7   16   4
  8   20   4
  9   25   5

  - max = floor(sqrt(d))
  - sqrt(d)가 정수이면 count가 짝수이므로 count = max*2
  - sqrt(d)가 실수이면 count가 홀수, count = max*2 -1
  - 최대 이동거리의 사잇값을 가지면 한번 더 이동해야 한다. 예를 들어 이동해야하는 거리가 8이라면 6과 9의 사이이고,
    9만큼의 이동횟수를 가져야 8만큼 이동이 가능하다.
   - 위에서 구한 max값으로 d 값을 다시 만들었을 때 입력받은 이동거리보다 작다면 한번 더 이동.(count++)
 */

public class FlymetotheAlphaCentauri {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance = y - x;
            int maximumStep = (int)Math.sqrt(distance);
            int count=0;

            if(Math.sqrt(distance) == maximumStep){
                count = maximumStep * 2 -1;
            }else{
                count = maximumStep * 2;

                // 사잇값을 가지므로 한번 더 이동.
                if(count % 2 != 0){
                    if(distance > Math.pow(maximumStep, 2)){
                        count ++;
                    }
                }else{
                    if(distance > Math.pow(maximumStep,2) + maximumStep){
                        count++;
                    }
                }
            }
            System.out.println(count);

        }


    }
}
