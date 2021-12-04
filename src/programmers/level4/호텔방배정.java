package programmers.level4;

import java.util.HashSet;
import java.util.Set;

public class 호텔방배정 {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        int p = 0;
        Set<Long> room = new HashSet<>();

        for(long roomNumber : room_number){
            if(!room.contains(roomNumber)){
                room.add(roomNumber);
                answer[p++] = roomNumber;
            }
            else{
                while(room.contains(++roomNumber));
                room.add(roomNumber);
                answer[p++] = roomNumber;
            }
        }

        return answer;
    }
}

class Node{
    long roomNumber;
    Node next;

    public Node(long roomNumber){
        this.roomNumber = roomNumber;
    }

    public void setNest(Node node){
        this.next = node;
    }
}
