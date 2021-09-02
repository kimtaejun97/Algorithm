package programmers;


public class 수식최대화_2 {

    public long solution(String expression){

        long answer = 0;
        long candidate=0;

        // + - *
        String[] operators = {"+","-","*"};
        String result = expression;
        for(String operator : operators){
            result = culExpression(operator, result, 0);
        }
        answer = Math.abs(Long.valueOf(result));

        // + * -
        operators = new String[]{"+", "*", "-"};
        answer = getAnswer(expression, answer, operators);

        // - * +
        operators = new String[]{"-", "*", "+"};
        answer = getAnswer(expression, answer, operators);

        // - + *
        operators = new String[]{"-", "+", "*"};
        answer = getAnswer(expression, answer, operators);

        // * + -
        operators = new String[]{"*", "+", "-"};
        answer = getAnswer(expression, answer, operators);

        // * - +
        operators = new String[]{"*", "-", "+"};
        answer = getAnswer(expression, answer, operators);



        return answer;
    }

    private long getAnswer(String expression, long answer, String[] operators) {

        String result = expression;
        long candidate = 0l;

        for(String operator : operators){
            result = culExpression(operator, result, 0);
        }
        candidate = Math.abs(Long.valueOf(result));

        if(candidate > answer){
            return candidate;
        }
        return answer;
    }


    public String culExpression(String op , String exp, int start) {

        String expression = exp;
        int index = expression.indexOf(op, start);
        String result= "";

        if(index == -1){
            return expression;
        }

        int startIndex = getStartIndex(expression, index);
        int endIndex = getEndIndex(expression, index);
        String subExp = expression.substring(startIndex, endIndex);

        String target1 = expression.substring(startIndex, index);
        String target2 = expression.substring(index + 1 , endIndex);

        switch (op){
            case "+":
                result = String.valueOf(Long.valueOf(target1) + Long.valueOf(target2));
                break;
            case "-":
                if(target1.equals("")){
                    return culExpression(op, expression, index+1);
                }
                result = String.valueOf(Long.valueOf(target1) - Long.valueOf(target2));
                break;
            case "*":
                result = String.valueOf(Long.valueOf(target1) * Long.valueOf(target2));
                break;
        }
        expression =  expression.replace(subExp, result);

        return culExpression(op,expression, 0);

    }

    private int getStartIndex(String exp, int index) {

        while(true){
            index -= 1;
            if(index <= 0){
                return 0;
            }
            char c = exp.charAt(index);
            if((c <'0' || c > '9')){
                return index + 1;
            }
        }

    }
    private int getEndIndex(String exp, int index) {
        int initIndex = index;
        while(true){
            index += 1;
            if(index == exp.length()-1){
                return exp.length();
            }
            char c = exp.charAt(index);
            if((c <'0' || c > '9') && index !=initIndex +1){
                return index;
            }
        }

    }

}
