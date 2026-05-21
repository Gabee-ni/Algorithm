import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<prices.length; i++){
            queue.offer(prices[i]);
        }
        
        int idx = 0;
        while(!queue.isEmpty()){
            int num = queue.poll();
            
            for(int q : queue){
                answer[idx]++; 
                if(q < num) break;
            }
            idx++;
        }
        return answer;
    }
}