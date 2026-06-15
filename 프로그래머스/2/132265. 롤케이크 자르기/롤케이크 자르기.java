import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> older = new HashMap<>(); 
        Map<Integer, Integer> younger = new HashMap<>(); 
        
        older.put(topping[0],1); 
        for(int j=1; j<topping.length; j++) younger.put(topping[j], younger.getOrDefault(topping[j],0)+1); 
        
        for(int i=1; i<topping.length-1; i++) {
            older.put(topping[i], older.getOrDefault(topping[i],0)+1); 
            younger.put(topping[i], younger.getOrDefault(topping[i],0)-1);
            
            if(younger.get(topping[i]) == 0) younger.remove(topping[i]);
            
            if(older.size() == younger.size()) answer ++; 
        }
        return answer;
    }
}