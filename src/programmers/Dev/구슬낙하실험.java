package programmers.Dev;
/*
구슬이 바닥으로 떨어지는 모든 시작 위치
 */
public class 구슬낙하실험 {
    public int solution(String[] drum) {
        int answer = 0;
        char[][] board = new char[drum.length][];
        for(int i = 0; i< drum.length; i++){
            board[i] = drum[i].toCharArray();
        }

        for(int start = 0; start< board[0].length; start++){
            boolean startStopFlag = false;
            int row = 0;
            int col = start;

            while(row < board.length){
                char flag = board[row][col];
                if(flag == '*'){
                    if(startStopFlag) break;
                    else {
                        row ++;
                        startStopFlag = true;
                    }
                }
                else if(flag == '#') row++;
                else if(flag == '>') col ++;
                else if(flag == '<') col --;
            }

            if(row >= board.length) answer ++;
        }

        return answer;
    }
}
