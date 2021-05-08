package codingtest;

import java.util.ArrayList;
import java.util.Stack;

public class p3_2 {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        boolean[] exst = new boolean[n];

        ArrayList<Integer> table = new ArrayList<>();
        Stack<Integer> zMemory = new Stack<>();
        int current = k;

        for(int i=0; i<n; i++){
            table.add(i);
        }

        for(String cm : cmd){
            if(cm.length() >1){
                String[] udCmd = cm.split(" ");
                if(udCmd[0].equals("U")){
                    if(current - Integer.parseInt(udCmd[1]) >=0 )
                        current -=Integer.parseInt(udCmd[1]);
                    else
                        current = 0;
                }
                else{
                    if(current + Integer.parseInt(udCmd[1]) <table.size() )
                        current +=Integer.parseInt(udCmd[1]);
                    else
                        current = table.size() -1;
                }
            }
            else{
                if(cm.equals("C")){
                    zMemory.push(table.get(current));
                    table.remove(current);
                    if(current == table.size()-1)
                        current -=1;
                }
                //Z
                else {
                    int zNum = zMemory.peek();
                    if( zNum==n-1)
                        table.add(zMemory.pop());
                    else{
                        int loc;
                        while(true){
                            if(zNum <n-1)
                                zNum++;
                            else{
                                table.add(zMemory.pop());
                                break;
                            }
                            loc = table.indexOf(zNum);
                            if(loc !=-1){
                                table.add(loc,zMemory.pop());
                                break;
                            }
                        }

                    }
                }
            }
        }

        for(int i =0; i<table.size(); i++){
            exst[table.get(i)] = true;
        }
        for(boolean e : exst){
            if(e)
                answer+="O";
            else
                answer+="X";
        }

        return answer;
    }
}
