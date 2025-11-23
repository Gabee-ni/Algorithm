import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }

        int temp = 1;
        for(String key : map.keySet()){
            temp *= (map.get(key)+1);
        }

        if(map.size()>1) return temp-1;
        else return clothes.length;
    }
}