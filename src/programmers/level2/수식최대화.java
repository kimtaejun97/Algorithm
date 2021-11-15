package programmers.level2;

import java.util.*;
/*
값을 연산한 후 숫자 배열에서 이를 합치고, 연산을 제거
numbers: 100 200 300
op: - +
인 상태라면 0번째 인덱스에 있는 - 연산은 numbers[0], numbers[1]에 적용된다.
1. 완전 탐색을 이용하여 연산자 우선순위를 결정.
2. 해당 연상자를 탐색하며 값을 연산한 후 두 수와 사용한 연산자를 제거해준다.
3. 연산 결과를 다시 해당 인덱스에 넣어준다.

 */
public class 수식최대화 {
    static List<Long> numbers = new ArrayList<>();
    static List<Character> expOp = new ArrayList<>();
    static Set<Character> kindOfOp = new HashSet<>();
    static boolean[] selected;
    static char[] priority;
    static long answer = 0;

    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();

        // 수, 연산자 분리.
        for (char c : expression.toCharArray()) {
            if (isNumber(c)) sb.append(c);
            else {
                numbers.add(Long.parseLong(sb.toString()));
                expOp.add(c);
                kindOfOp.add(c);
                sb = new StringBuilder();
            }
        }
        numbers.add(Long.parseLong(sb.toString()));

        selected = new boolean[kindOfOp.size()];
        priority = new char[kindOfOp.size()];

        dfs(0);

        return answer;
    }

    private void dfs(int depth) {
        // 우선순위가 결정되면 값을 계산.
        if (depth >= kindOfOp.size()) {
            ArrayList<Long> nums = new ArrayList();
            nums.addAll(numbers);
            ArrayList<Character> ops = new ArrayList<>();
            ops.addAll(expOp);

            for (char op : priority) {
                int idx = ops.indexOf(op);
                while (idx != -1) {

                    long result = culExpression(nums.get(idx), op, nums.get(idx + 1));
                    ops.remove(idx);
                    nums.remove(idx + 1);
                    nums.remove(idx);
                    nums.add(idx, result);

                    idx = ops.indexOf(op);
                }
            }
            answer = Math.max(answer, Math.abs(nums.get(0)));
        }

        int i = 0;
        for (char op : kindOfOp) {
            if (!selected[i]) {
                priority[depth] = op;
                selected[i] = true;
                dfs(depth + 1);
                selected[i] = false;
            }
            i++;
        }
    }

    private long culExpression(Long num1, char op, Long num2) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return 0;
    }

    private boolean isNumber(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }

}
