package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방_2 {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        List<String> rec = new ArrayList<>();
        int count =0;

        for(String r : record){
            String[] s = r.split( " ");
            if(s[0].equals("Enter")){
                user.put(s[1], s[2]);
                rec.add(s[1]+"님이 들어왔습니다.");
            }
            if(s[0].equals("Leave")){
                rec.add(s[1]+"님이 나갔습니다.");
            }
            if(s[0].equals("Change")){
                user.put(s[1], s[2]);
            }
        }

        String[] answer = new String[rec.size()];

        for(String r : rec){
            String uid = r.split("님")[0];
            answer[count++] = r.replace(uid, user.get(uid));
        }

        return answer;
    }
}
