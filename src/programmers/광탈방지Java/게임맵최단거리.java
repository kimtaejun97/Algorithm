package programmers.광탈방지Java;

import java.util.LinkedList;
import java.util.Queue;

/*
BFS
 */
public class 게임맵최단거리 {
    static boolean[][] visit;
    static int minMove;
    static int[] X = new int[]{0, 0, -1, 1};
    static int[] Y = new int[]{1, -1, 0, 0};
    static Queue<Node> queue = new LinkedList<>();
    static int destX, destY;



    public int solution(int[][] maps) {

        destX = maps[0].length-1;
        destY = maps.length-1;
        visit = new boolean[maps.length][maps[0].length];
        minMove = maps.length * maps[0].length + 1;

        bfs(maps);
        // 갈 수 있는 길이 없음.
        if(minMove == maps.length * maps[0].length + 1){
            return -1;
        }
        return minMove;
    }

    private void bfs(int[][] maps) {

        queue.add(new Node(0,0, 1));
        visit[0][0] = true;

        while(!queue.isEmpty()){
            Node currNode = queue.poll();

            if(currNode.x == destX && currNode.y == destY){
                minMove = Math.min(minMove, currNode.move);
            }

            //현재 노드의 상하좌우 탐색.
            for(int i=0; i<4; i++){
                int nextX = currNode.x + X[i];
                int nextY = currNode.y + Y[i];

                // maps의 범위를 벗어나지 않고, 벽이 아니며, 방문하지 않은 노드.
                if(isMapsRange(nextX, nextY) && maps[nextY][nextX] !=0
                        && !visit[nextY][nextX]){
                    queue.add(new Node(nextX, nextY, currNode.move+1));
                    visit[nextY][nextX] = true;
                }
            }
        }
    }

    private boolean isMapsRange(int x, int y) {
        if(x < 0 || x > destX || y < 0 || y > destY) return false;
        return true;
    }
}

class Node{
    int x;
    int y;
    int move;

    public Node(int x, int y, int move){
        this.x = x;
        this.y = y;
        this.move = move;
    }
}