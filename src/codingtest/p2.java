package codingtest;

public class p2 {
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

    public static void main(String[] args) {
        p2 c = new p2();
        int[][] solution = c.solution(3, true, new int[]{1,1, 2,1,3,3,2});

        for(int[] a : solution){

            for(int b : a)
                System.out.println(b);
            System.out.println("/");
        }

    }
}
