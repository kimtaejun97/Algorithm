package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
- 하나의 컬럼으로 유일키가 되는 경우 이를 후보키의 조합을 위해 사용할 수 없음.(마크)
- 마크되지 않은 열들의 조합으로 후보키를 생성 (2~ 컬럼의 길이 - 마크된 열의 수)
- 다음 길이의 후보키를 생성할 때는 이전 더 짧은 후보키 리스트에서 탐색, 최소성을 검사.
- 최소성 검사를 통과하면 유일성 검사.
 */
public class 후보키 {
    static List<String> candidate = new ArrayList<>();
    static boolean[] singleKey;
    static int[] selected;
    static int combinationLength = 0;
    static int columnLength;
    static int rowLength;
    static String[][]  table;
    public int solution(String[][] relation) {
        columnLength = relation[0].length;
        rowLength = relation.length;
        table = relation;
        singleKey = new boolean[columnLength];
        selected = new int[columnLength+1];

        // dfs에서 자신을 호출한 함수에서 선택한 컬럼넘버 이상의 컬럼부터 탐색하기 위해 사용. depth 1을 위해 -1로 초기화.
        selected[0] = -1;

        // 한 개의 컬럼의로 유일하게 식별하는 컬럼 마크.
        for(int i=0; i< singleKey.length; i++) singleKey[i] = true;

        for(int column = 0; column<columnLength; column++){
            for(int source = 0; source< relation.length; source++){
                for(int dest = source+1; dest < relation.length; dest++){
                    if(relation[source][column].equals(relation[dest][column])){
                        singleKey[column] = false;
                        break;
                    }
                }
                if(!singleKey[column]) break;
            }
        }

        // 조합키
        for(int len = 2; len<= columnLength; len++){
            combinationLength = len;
            dfs(1);
        }

        // 싱글키 후보키로 등록
        for(int i=0; i< singleKey.length; i++){
            if(singleKey[i]) candidate.add(String.valueOf(i));
        }

        return candidate.size();
    }

    private void dfs(int depth) {
        if(depth > combinationLength){
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<=combinationLength; i++){
                sb.append(selected[i]);
            }
            // 새로운 조합키에 이전 후보키가 들어있는지 최소성 검사.
            String newKey = sb.toString();
            if(!isMinimum(newKey)) return;

            // 유일성 검사
            boolean unique = isUnique(Arrays.copyOfRange(selected, 1, combinationLength + 1));
            if(unique) candidate.add(newKey);
            return;
        }

        for(int i=selected[depth-1] + 1; i<columnLength; i++){
            if(!singleKey[i]){
                selected[depth] = i;
                dfs(depth+1);
            }
        }
    }

    private boolean isMinimum(String newKey) {
        char[] newKeyArr = newKey.toCharArray();
        boolean isContained = false;

        for(String candidateKey : candidate){
            for(char candidateElm : candidateKey.toCharArray()){
                isContained = false;
                for(char newKeyElm: newKeyArr){
                    if(candidateElm == newKeyElm){
                        isContained = true;
                        break;
                    }
                }
                if(!isContained) break;
            }
            if(isContained) return false;
        }
        return true;
    }

    private boolean isUnique(int[] colmuns) {
        // column 조합으로 데이터 생성.
        String[] combinationColumn = new String[rowLength];
        StringBuilder sb;
        for(int row=0; row<rowLength; row++){
            sb = new StringBuilder();
            for(int column : colmuns){
                sb.append(table[row][column]).append(" ");
            }
            combinationColumn[row] = sb.toString();
        }

        for(int i=0; i<rowLength-1; i++){
            for(int j=i+1; j<rowLength; j++){
                if(combinationColumn[i].equals(combinationColumn[j])) return false;
            }
        }
        return true;
    }
}
