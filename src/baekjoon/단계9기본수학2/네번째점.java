package baekjoon.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class 네번째점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        Point[] points = new Point[3];
        StringBuilder sb =new StringBuilder();

        for(int i=0; i<3; i++){
            String[] coordinate = br.readLine().split(" ");
            int x = Integer.parseInt(coordinate[0]);
            int y = Integer.parseInt(coordinate[1]);
            points[i] = new Point(x, y);
        }

        if(points[0].x == points[1].x){
            sb.append(points[2].x).append(" ");
        }else if(points[0].x == points[2].x){
            sb.append(points[1].x).append(" ");
        }else{
            sb.append(points[0].x).append(" ");
        }

        if(points[0].y == points[1].y){
            sb.append(points[2].y);
        }else if(points[0].y == points[2].y){
            sb.append(points[1].y);
        }else{
            sb.append(points[0].y);
        }

        System.out.println(sb.toString());
    }

}
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
