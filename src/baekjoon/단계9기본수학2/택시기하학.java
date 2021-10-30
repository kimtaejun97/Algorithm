package baekjoon.단계9기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

//D(T₁, T₂) = |𝑥₁ - 𝑥₂| + |y₁ - y₂|
public class 택시기하학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int r = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();
        sb.append(String.format("%.6f",Math.PI * r*r)).append("\n");
        sb.append(String.format("%.6f", (double)2*r*r));

        System.out.println(sb.toString());

    }
}
