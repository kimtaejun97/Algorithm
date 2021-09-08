package programmers;

public class l6_쉘명령어 {
    public String[] solution(String[] directory, String[] command){
        String[] answer ={};



        return answer;

    }

    public static void main(String[] args) {
        l6_쉘명령어 test = new l6_쉘명령어();
        String[] solution = test.solution(new String[]{"/",
                        "/hello",
                        "/hello/tmp",
                        "/root",
                        "/root/abcd",
                        "/root/abcd/etc",
                        "/root/abcd/hello"},
                new String[]{"mkdir /root/tmp",
                        "cp /hello /root/tmp",
                        "rm /hello"});

        for(String dir : solution){
            System.out.println(dir);
        }
    }
}
