package programmers;

public class 순위검색_2 {
    public int[] solution(String[] info, String[] queries) {
        int[] answer = new int[queries.length];
        int pointer = 0;
        int count =0;
        String[][] infoToken = new String[info.length][5];

        for(int i=0; i<info.length; i++){
            infoToken[i] = info[i].split(" ");
        }

        for(String q :queries){
            // 언어 직군 경력 소울푸드 점수
            q = q.replace("and", " ");
            q = q.replaceAll("[ ]{1,}", " ");
            String[] splitQuery = q.split(" ");

            // 쿼리 하나, 만족하는 인원 세기.
            for(int i=0; i<info.length; i++){
                boolean flag = true;

                // 4개 항목 동일한지 체크
                for(int j = 0; j<4; j++){
                    String item = splitQuery[j];
                    if(item.equals("-")){
                        continue;
                    }
                    if(!infoToken[i][j].equals(item)){
                        flag = false;
                        break;
                    }
                }
                // 점수 체크
                if(Integer.parseInt(infoToken[i][4]) < Integer.parseInt(splitQuery[4])){
                    flag = false;
                }

                if(flag){
                    count++;
                }
            }
            answer[pointer++] = count;
            count = 0;
        }
        return answer;
    }

}
