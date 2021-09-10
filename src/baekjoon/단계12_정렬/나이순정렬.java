package baekjoon.단계12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        String[][] members = new String[t][2];

        for(int i=0; i<t; i++){
            members[i] = br.readLine().split(" ");
        }

        Arrays.sort(members, new Comparator<String[]>() {
            @Override
            public int compare(String[] c1, String[] c2) {
               return Integer.compare(Integer.parseInt(c1[0]), Integer.parseInt(c2[0]));
            }
        });



        StringBuilder sb = new StringBuilder();
        for(String[] m : members){
            sb.append(m[0]).append(" ").append(m[1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
