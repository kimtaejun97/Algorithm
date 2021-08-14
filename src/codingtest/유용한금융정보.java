package codingtest;

public class 유용한금융정보 {

    public String solution(String input) {
        StringBuilder answer = new StringBuilder();

        String[] split = input.split("\n");

        int n = Integer.parseInt(split[0].split(" ")[0]);
        int m = Integer.parseInt(split[0].split(" ")[1]);
        answer.append(n).append(" ").append(m).append("\n");

        int day =1;
        int count =0;
        boolean negFlag = false;


        for(int i=1; i<split.length; i++){
            if(split[i].equals("SHOW")){
                if(count < n && !negFlag){
                    answer.append("1").append("\n");
                    count++;
                }
                else if(negFlag || count >= n ){
                    answer.append("0").append("\n");
                }

            }
            else if(split[i].equals("NEXT")){
                day ++;
                if(day>m){
                    count =0;
                    day = 1;
                }
                answer.append("-").append("\n");
            }
            else if(split[i].equals("NEGATIVE")){
                negFlag = true;
                answer.append("0").append("\n");

            }
            else if(split[i].equals("EXIT")){
                answer.append("BYE").append("\n");
            }
            else{
                answer.append("ERROR").append("\n");
            }

        }
        return answer.toString();
    }
}
