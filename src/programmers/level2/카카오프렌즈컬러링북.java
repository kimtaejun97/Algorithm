package programmers.level2;

import java.util.*;

public class 카카오프렌즈컬러링북 {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        // x,y 의 그룹 번호.
        int[][] groupOfCoor = new int[m][n];
        // 그룹, 속한 점.
        Map<Integer, List<int[]>> group = new HashMap<>();
        int groupNumber = 0;

        for(int y=0; y<m; y++){
            for(int x=0; x<n; x++){
                if(picture[y][x] != 0){
                    int curr =picture[y][x];
                    int topGroupNumber = -1;
                    int leftGroupNumber = -1;
                    // 위의 점과 그룹이 될 수 있는지 비교.
                    if(y > 0){
                        int top = picture[y-1][x];
                        if(top !=0 && top == curr){
                            topGroupNumber = groupOfCoor[y-1][x];
                            // 위의 점과 같은 그룹으로.
                            groupOfCoor[y][x] = topGroupNumber;
                            group.get(topGroupNumber).add(new int[]{y,x});
                        }
                    }
                    if(x > 0){
                        int left = picture[y][x-1];
                        // 왼쪽 점 그룹을 탐색하고 위의 그룹과 다르다면 병합.
                        if(left !=0 && left == curr){
                            leftGroupNumber = groupOfCoor[y][x-1];
                            // 위의 점이 그룹이 없을경우 왼쪽 점과 그룹.
                            if(topGroupNumber == -1){
                                groupOfCoor[y][x] = leftGroupNumber;
                                group.get(leftGroupNumber).add(new int[]{y,x});
                            }
                            // 왼쪽점과 위의 점의 그룹이 다르다면 위의 점의 그룹으로 병합.
                            else{
                                if(leftGroupNumber != topGroupNumber){
                                    List<int[]> leftGroup = group.get(leftGroupNumber);
                                    group.get(topGroupNumber).addAll(leftGroup);
                                    for(int[] point : leftGroup){
                                        int py = point[0];
                                        int px = point[1];
                                        groupOfCoor[py][px] = topGroupNumber;
                                    }
                                    group.remove(leftGroupNumber);
                                }
                            }
                        }
                    }
                    // 위, 왼쪽 모두 그룹이 없다면. 그룹을 새로 만듦.
                    if(topGroupNumber == -1 && leftGroupNumber == -1){
                        groupOfCoor[y][x] = groupNumber;
                        List<int[]> newGroup = new ArrayList<>();
                        newGroup.add(new int[]{y,x});
                        group.put(groupNumber, newGroup);
                        groupNumber++;
                    }
                }
            }
        }

        numberOfArea = group.size();
        for(List<int[]> g : group.values()){
            maxSizeOfOneArea = Math.max(maxSizeOfOneArea, g.size());
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
