import java.util.*;
class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights); 
        
        Map<Integer, Long> count = new HashMap<>(); 
        long answer = 0; 
        
        for(int weight : weights ){
            // 같은 무게 
            answer += count.getOrDefault(weight, 0L); 

            if(weight * 2 % 3 == 0){
                answer += count.getOrDefault(weight * 2 / 3, 0L);
            }
            
            if(weight % 2 == 0) {
                answer += count.getOrDefault(weight / 2, 0L); 
            }
            
            if(weight * 3 % 4 == 0){
                answer += count.getOrDefault(weight * 3 / 4, 0L);
            }
            
            count.put(weight, count.getOrDefault(weight, 0L) + 1); 
        }
    
        return answer;
    }
}