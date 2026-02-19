import java.util.*; 
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        answer = Arrays.stream(numbers)
                        .boxed()
                        .sorted((o1,o2)-> {
                            String num1 = String.valueOf(o1);
                            String num2 = String.valueOf(o2);
                            
                            return (num2+num1).compareTo(num1+num2);
                        })
                        .map(String::valueOf)
                        .collect(Collectors.joining());

        if (answer.charAt(0) == '0') return "0";
        return answer;
    }
}