package codility;
/*
결과: [순찰선 , 잠수함, 구축함]
 */
public class p3 {

    public int[] solution(String[] B) {
        int[] answer = new int[3];
        char[][] board = new char[B.length][];
        int p = 0;
        for(String row : B){
            board[p++] = row.toCharArray();
        }
        int colLength = board[0].length;
        int rowLength = board.length;

        for(int row = 0; row<board.length; row++){
            for(int col = 0; col< colLength; col++){
                int count =0;
                if(board[row][col] == '#'){
                    count ++;
                    board[row][col] = '.';
                    // right
                    if(col+1 < colLength && board[row][col+1] == '#'){
                        board[row][col+1] = '.';
                        count ++;
                        //right
                        if(col+2 < colLength && board[row][col+2] == '#'){
                            board[row][col+2] = '.';
                            count ++;
                        }
                        // bottom
                        else if(row+1 < rowLength && board[row+1][col+1] == '#'){
                            board[row+1][col+1] = '.';
                            count ++;
                        }
                    }

                    // bottom
                    if(row+1 < rowLength && board[row+1][col] == '#'){
                        board[row+1][col] = '.';
                        count ++;

                        // left
                        if(col-1 >=0 && board[row+1][col-1] == '#'){
                            board[row+1][col-1] = '.';
                            count++;
                        }
                        // right
                        else if(col+1 < colLength && board[row+1][col+1] == '#'){
                            board[row+1][col+1] = '.';
                            count ++;
                        }
                        // bottom
                        else if(row +2 < colLength && board[row+2][col] == '#'){
                            board[row+2][col] = '.';
                            count ++;
                        }
                    }
                    answer[count-1] ++;
                }
            }
        }
        return answer;
    }
}
