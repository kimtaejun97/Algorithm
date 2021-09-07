package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Character.isDigit;

public class 파일명정렬_2 {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        // comparator를 이용한 정렬
        List<String> sorted = Arrays.stream(files)
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {

                        String s1Head = "";
                        int s1Number = -1;
                        String s2Head = "";
                        int s2Number = -1;
                        int startNumberIndex = 0;

                        // s1 head
                        for (int i = 0; i < s1.length(); i++) {
                            if (isDigit(s1.charAt(i))) {
                                s1Head = s1.substring(0, i);
                                startNumberIndex = i;
                                break;
                            }
                        }
                        // s1 number
                        for (int i = startNumberIndex+1; i < s1.length(); i++) {
                            if (!isDigit(s1.charAt(i))) {
                                s1Number = Integer.parseInt(s1.substring(startNumberIndex, i));
                                break;
                            }
                        }
                        if(s1Number == -1){
                            s1Number = Integer.parseInt(s1.substring(startNumberIndex));
                        }

                        // s2 head
                        for (int i = 0; i < s2.length(); i++) {
                            if (isDigit(s2.charAt(i))) {
                                s2Head = s2.substring(0, i);
                                startNumberIndex = i;
                                break;
                            }
                        }
                        // s2 number
                        for (int i = startNumberIndex+1; i < s2.length(); i++) {
                            if (!isDigit(s2.charAt(i))) {
                                s2Number = Integer.parseInt(s2.substring(startNumberIndex, i));
                                break;
                            }
                        }
                        if(s2Number == -1){
                            s2Number = Integer.parseInt(s1.substring(startNumberIndex));
                        }

                        if (s1Head.compareToIgnoreCase(s2Head) < 0) {
                            return -1;
                        } else if (s1Head.compareToIgnoreCase(s2Head) == 0) {
                            if (s1Number < s2Number) {
                                return -1;
                            } else {
                                // 숫자까지 같으면 제자리.
                                return 1;
                            }
                        } else {
                            return 1;
                        }
                    }
                }).collect(Collectors.toList());

        for(int i =0; i< answer.length; i++){
            answer[i] = sorted.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        파일명정렬_2 test = new 파일명정렬_2();
        test.solution(new String[] {"img 0 .p2ng","img2025.png123","a-5"});

    }
}
