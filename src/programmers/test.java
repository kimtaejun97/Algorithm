package programmers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String pattern = "^[0-9]*$";
        String target = "1241509";
        boolean regexMatches = Pattern.matches(pattern, target);
        System.out.println(regexMatches);

    }
}
