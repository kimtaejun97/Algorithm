package programmers;

import java.util.ArrayList;

public class Crane {
        public static int solution(int[][] board, int[] moves) {

            int answer = 0;
            int[] top = new int[board.length];
            ArrayList<Integer> itemList= new ArrayList<>();
            int prev_item=0;

            for(int i =0; i<top.length; i++)
                for (int j = 0; j<board.length; j++){
                    if(board[j][i] !=0) {
                        top[i] = j;
                        break;
                    }
                }

            for(int i =0; i<moves.length; i++){
                int row =moves[i]-1;
                int col = top[row];
                int item =0;

                if (top[row] < board.length) {
                    item =board[col][row];
                    top[row]++;
                }
                else
                    continue;


                if(itemList.size() !=0) {
                    prev_item = itemList.get(itemList.size() - 1);

                    if (prev_item == item) {
                        itemList.remove(itemList.size() - 1);
                        answer += 2;
                        continue;
                    }
                }
                itemList.add(item);

            }
            return answer;
        }

    public static void main(String[] args) {
            int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
            int[] moves ={1,5,3,5,1,2,1,4};
            //4,3,1,1,3,2,0,4
        int answer = solution(board, moves);
        System.out.println(answer);
    }

}
