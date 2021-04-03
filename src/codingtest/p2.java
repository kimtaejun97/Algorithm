package codingtest;

public class p2 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int ansc=0;

        int[][] rc = new int[rows+1][columns+1];
        int[][] copyrc =new int[rows+1][columns+1];

        for (int i = 1 ; i<=rows; i++){
            for(int j = 1; j<=columns; j++){
                rc[i][j] = (i-1) * columns + j;
            }
        }
        for(int i=0; i<rc.length; i++)
            System.arraycopy(rc[i], 0, copyrc[i], 0, rc[0].length);

        for(int[] query: queries){
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[0];
            int y2 = query[1];

            int buff = rc[x1][y1];
            //left col
            for (int i=x1+1; i<=x2; i++ )
                rc[i-1][y1] = rc[i][y1];
            //bottom row
            for(int j=y1+1; j<=y2; j++)
                rc[x2][j-1] = rc[x2][j];
            //right col
            for(int k=x2-1; k>=x1; k--)
                rc[k+1][y2] = rc[k][y2];
            //top row
            for(int t= y2-1; t>y1; t--)
                rc[x1][t+1]  =rc[x1][t];

            rc[x1][y1+1] =buff;

            //바뀐것 중 최솟값 찾기.
            int minnum = rows *columns +1;
            for(int i =1; i<=rows; i++){
                for(int j = 1; j<=columns; j++){
                    if(rc[i][j] != copyrc[i][j]){
                        minnum = minnum<rc[i][j]? minnum:rc[i][j];
                    }
                }
            }
            answer[ansc] = minnum;
            ansc ++;
            for(int i=0; i<rc.length; i++)
                System.arraycopy(rc[i], 0, copyrc[i], 0, rc[0].length);

        }

        return answer;
    }

    public static void main(String[] args) {
        p2 p = new p2();
        int[][] q = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int[] re = p.solution(6,6,q);
        System.out.println(re);
    }
}
