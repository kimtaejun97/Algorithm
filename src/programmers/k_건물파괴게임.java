package programmers;

public class k_건물파괴게임 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        // 스킬 사용
        for(int[] s : skill){
            // 공격
            if(s[0] ==1){
                for(int i=s[1]; i<=s[3]; i++){
                    for(int j = s[2]; j<=s[4]; j++){
                        board[i][j] -= s[5];
                    }
                }
            }
            // 회복
            else{
                for(int i=s[1]; i<=s[3]; i++){
                    for(int j = s[2]; j<=s[4]; j++){
                        board[i][j] +=  s[5];
                    }
                }
            }
        }

        // 건물 상태 확인
        for(int[] r : board){
            for(int e : r){
                if(e > 0){
                    answer ++;
                }
            }
        }

        return answer;

    }
}
