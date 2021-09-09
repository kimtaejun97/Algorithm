package programmers;

import java.util.*;

public class l6_쉘명령어 {
    public String[] solution(String[] directory, String[] command){
        String[] answer ={};
        Set<String> dir = new HashSet<>();
        dir.addAll(Arrays.asList(directory));

        for(String c : command){
            String[] split = c.split(" ");
            String cmd = split[0];
            String targetDir =split[1];

            // 디렉토리 생성
            if(cmd.equals("mkdir")){
                dir.add(targetDir);
            }
            // 디렉토리 복사 : 해당 디렉토리 문자열로 시작하는 경로에서 마지막 디렉토리 부터만 복사.
            else if(cmd.equals("cp")){
                String dest =split[2];
                StringBuilder dirNameBuilder;
                Set<String> subs = new HashSet<>();

                // 같은 경로를 가진 디렉토리중 가장 긴 문자열들 에서 경로의 마지막 디렉토리명 부터 끝까지 복사.
                for(String d : dir){
                    if(d.startsWith(targetDir)){
                        dirNameBuilder = new StringBuilder(dest);
                        int targetLength =d.length();
                        int startIndex = targetDir.lastIndexOf("/")+1;

                        if(dest.charAt(dest.length()-1) =='/'){
                            dirNameBuilder.append(d.substring(startIndex));
                        }
                        else{
                            dirNameBuilder.append("/").append(d.substring(startIndex));
                        }
                        subs.add(dirNameBuilder.toString());
                    }
                }
                dir.addAll(subs);
            }
            // 디렉토리 제거.
            else{
                for(Iterator<String> it = dir.iterator(); it.hasNext();){
                    if(it.next().startsWith(split[1])){
                        it.remove();
                    }
                }
            }
        }

        answer = new String[dir.size()];
        int p = 0;
        for(String d: dir){
            answer[p++] = d;
        }

        Arrays.sort(answer);

        return answer;

    }

    public static void main(String[] args) {
        l6_쉘명령어 test = new l6_쉘명령어();
        String[] solution = test.solution(new String[]{"/"},
//                        "/hello",
//                        "/hello/tmp",
//                        "/root",
//                        "/root/abcd",
//                        "/root/abcd/etc",
//                        "/root/abcd/hello"},
                new String[]{"mkdir /a",
                        "mkdir /a/b",
                        "mkdir /a/b/c",
                        "cp /a/b /",
                        "rm /a/b/c"});

        for(String dir : solution){
            System.out.println(dir);
        }
    }
}
