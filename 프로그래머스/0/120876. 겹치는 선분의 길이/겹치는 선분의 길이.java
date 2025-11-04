import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int[] line : lines){
            int start = Math.min(line[0], line[1]);
            int end = Math.max(line[0], line[1]);
            
            for(int i=start;i<end;i++){
                 map.merge(i,1,(a,b)->a+b);
            }
            
        }
        
        return (int)map.values().stream().filter(i->i>1).count();
    }
}