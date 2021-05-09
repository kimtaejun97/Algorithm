package programmers;


import java.util.Stack;

public class p3 {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        boolean[] del = new boolean[n];
        int current = k;
        int top= 0;
        int bottom= n-1;
        Stack<Integer> zMemory= new Stack<>();

        for(String cm : cmd){
            if(cm.length() >1){
                String[] udCmd = cm.split(" ");
                int ud = Integer.parseInt(udCmd[1]);
                if(udCmd[0].equals("U")){
                    for(int i=0; i<ud; i++){
                        if(current > top){
                            current--;
                            while(del[current])
                                current--;
                        }
                    }
                }
                else{
                    for(int i=0; i<ud; i++){
                        if(current < bottom){
                            current++;
                            while(del[current])
                                current++;
                        }
                    }
                }
            }
            else{
                if(cm.equals("C")){
                    del[current] = true;
                    zMemory.push(current);

                    if(current==bottom){
                        if(current-1 >=top){
                            current =current-1;
                            while(del[current])
                                current=-1;
                            bottom =current;
                        }
                    }
                    else{
                        int curbuff = current;
                        current =current+1;
                        while(del[current])
                            current+=1;
                        if (curbuff ==top)
                            top = current;
                    }
                }
                else{
                    del[zMemory.pop()] = false;
                }
            }
        }

        for(boolean r : del)
            if(r)
                answer+="X";
            else
                answer+="O";

        return answer;
    }

}
