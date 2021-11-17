import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
    }

    List<Integer> test(){
        int[] arr = new int[2];

        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

}
