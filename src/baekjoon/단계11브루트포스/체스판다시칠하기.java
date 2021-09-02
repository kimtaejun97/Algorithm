package baekjoon.단계11브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        int height = Integer.parseInt(stringTokenizer.nextToken());
        int width = Integer.parseInt(stringTokenizer.nextToken());

        int expected = 0;
        char[] wb = {'W', 'B'};
        int result = height * width;

        String [] block = new String[height];

        for(int i = 0; i<height; i++){
            block[i] = br.readLine();
        }

        for(int h = 0; h+7<height; h++){
            for(int w = 0; w+7<width; w++){
                if(block[h].charAt(w) =='W'){
                    expected = 0;
                }
                else{
                    expected = 1;
                }
                int wrong = 0;

                for(int mh = h; mh<=h+7; mh++){
                    for(int mw = w; mw<=w+7; mw++){
                        if(block[mh].charAt(mw) != wb[expected]){
                            wrong ++;
                        }
                        if(mw != w+7){
                            expected = (expected+ 1) % 2;
                        }
                    }
                }
                if(wrong < result)
                    result = wrong;
            }
        }
        System.out.println(result);
    }
}
