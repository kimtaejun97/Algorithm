package programmers.광탈방지Java;

/*
동적 계획
 */
public class 정수삼각형 {
    public int solution(int[][] triangle) {

        for(int i = triangle.length-1; i>0; i--){
            for(int j=0; j<triangle[i].length-1; j++){
                triangle[i-1][j] = Math.max(triangle[i][j], triangle[i][j+1])
                                        + triangle[i-1][j];
            }
        }

        return triangle[0][0];
    }
}
