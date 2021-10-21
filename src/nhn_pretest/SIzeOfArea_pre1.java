package nhn_pretest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SIzeOfArea_pre1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int groupNumber =0;
        int sizeOfArea = Integer.parseInt(br.readLine());
        Map<Integer, ArrayList<Coordinate>> group = new HashMap<>();
        char[][] matrix = new char[sizeOfArea][sizeOfArea];


        // 행렬 데이터 수신.
        for(int i=0; i<sizeOfArea; i++){
            matrix[i] = br.readLine().replace(" ", "").toCharArray();
        }

        // 그룹화.
        for(int i =0 ; i<sizeOfArea; i++){
            for(int j = 0; j<sizeOfArea; j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                // '상'의 그룹에 추가.
                if(i > 0 && matrix[i-1][j] == '1'){
                    int findGroupNumber = findGroup(new Coordinate(i-1,j), group);
                    group.get(findGroupNumber).add(new Coordinate(i,j));


                    // '좌'와 인접하지만 그룹이 다르게 배정된 경우 병합.
                    if(j > 0 && matrix[i][j-1] == '1'){
                        int leftCoordinateGroupNumber = findGroup(new Coordinate(i,j-1), group);
                        if(leftCoordinateGroupNumber != findGroupNumber){
                            group.get(findGroupNumber)
                                .addAll(group.get(leftCoordinateGroupNumber));

                            group.remove(leftCoordinateGroupNumber);
                        }

                    }
                    continue;
                }
                // '좌'의 그룹에 추가.
                else if(j > 0 && matrix[i][j-1] == '1'){
                    int findGroupNumber = findGroup(new Coordinate(i,j-1), group);
                    group.get(findGroupNumber).add(new Coordinate(i,j));
                }
                // 새 그룹 생성
                else {
                    ArrayList<Coordinate> newGroup = new ArrayList<>();
                    newGroup.add(new Coordinate(i,j));
                    group.put(groupNumber++, newGroup);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        int[] groupSize = new int[group.size()];
        result.append(group.size()).append("\n");

        int i =0;
        for(int key : group.keySet()){
            groupSize[i++] = group.get(key).size();
        }
        Arrays.sort(groupSize);

        for(int s : groupSize){
            result.append(s).append(" ");
        }
        System.out.println(result.toString());

    }

    private static int findGroup(Coordinate coordinate, Map<Integer, ArrayList<Coordinate>> group) {
        for(int key : group.keySet()){
            if(group.get(key).contains(coordinate)){
                return key;
            }
        }

        return -1;
    }
}

class Coordinate {
    private int x;
    private int y;

    private Coordinate(){}

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

