package programmers;

public class 서버요청분배 {
    public int[][] solution(int servers, boolean sticky, int[] requests) {
        int[][] answer = new int[servers][];

        int pointer = 0;
        boolean flag = false;
        String[] anw = new String[servers];

        for(int i = 0; i<servers; i++)
            anw[i] ="";

        for(int req : requests){
            if(!sticky){
                anw[pointer] += req;
                pointer = (pointer+1) % servers;

            }
            else{
                for(int i = 0; i<servers ; i++){
                    if(anw[i].indexOf(String.valueOf(req)) >= 0){
                        anw[i] += req;
                        flag = true;
                    }
                }
                if(!flag){
                    anw[pointer] += req;
                    pointer = (pointer+1) % servers;
                }
            }
            flag =false;

        }

        for(int i=0; i<servers; i++){
            int batch =anw[i].length();
            int[] arr =new int[batch];
            for(int j= 0; j<batch; j++){
                arr[j] = Integer.parseInt(anw[i].substring(j,j+1));
            }

            answer[i] = arr;
        }


        return answer;
    }

}
