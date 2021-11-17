package programmers.level2;

import java.util.PriorityQueue;

public class 파일명정렬 {
    public String[] solution(String[] files) {
        String[] answer = {};
        PriorityQueue<File> q = new PriorityQueue<>();

        for(int i=0; i< files.length; i++){
            q.add(new File(files[i], i));
        }

        answer = new String[q.size()];
        int p =0;
        while(!q.isEmpty()){
            answer[p++] = q.poll().fileFullName;
        }

        return answer;
    }
}
class File implements Comparable<File>{
    String head;
    int number;
    String fileFullName;
    int sequence;

    public File(String fileName, int seq){
        this.fileFullName = fileName;
        this.sequence = seq;
        setHeadAndNumber(fileName);
    }

    private void setHeadAndNumber(String fileName) {
        int startNumberIdx = 0;
        int endNumberIdx = 0;
        char[] file = fileName.toCharArray();
        for(int i=0; i<file.length; i++){
            if(Character.isDigit(file[i]) && startNumberIdx == 0){
                startNumberIdx = i;
            }
            else if(startNumberIdx!=0 &&
                    (!Character.isDigit(file[i]) || i - startNumberIdx >= 5 )){
                endNumberIdx = i-1;
                break;
            }
        }
        // 파일명이 숫자로 끝남.
        if(endNumberIdx == 0 ) endNumberIdx = file.length -1;
        this.head = fileName.substring(0,startNumberIdx).toUpperCase();
        this.number = Integer.parseInt(fileName.substring(startNumberIdx, endNumberIdx+1));
    }

    @Override
    public int compareTo(File target) {
        if(this.head.equals(target.head)){
            if(this.number == target.number) return this.sequence - target.sequence;
            else return this.number - target.number;
        }else{
            return this.head.compareTo(target.head);
        }
    }
}
