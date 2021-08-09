package baekjoon.단계7문자열;
/*
č	c=
ć	c-
dž	dz=
đ	d-
lj	lj
nj	nj
š	s=
ž	z=
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아알파벳 {
    static final String[] ALPHABETS = new String[]{"c=", "c-", "dz=","d-","lj","nj","s=","z="};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for(String alphabet : ALPHABETS){
            input = input.replace(alphabet,"#");
        }

        System.out.println(input.length());

    }
}
