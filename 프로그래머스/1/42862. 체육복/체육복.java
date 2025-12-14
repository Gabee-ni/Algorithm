import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> list  = new ArrayList<>();
        
        for(int num : reserve){
            list.add(num);
        }
        
        Arrays.sort(lost);
        Collections.sort(list);
        
        for(int i=0; i<lost.length;i++){
            if(list.contains(lost[i])) {
                answer++;
                list.set(list.indexOf(lost[i]),0);
                lost[i] = 0;
                continue;
            }
        }
        
        for(int i=0; i<lost.length;i++){
            if(lost[i]==0) continue;
            for(int j=0; j<list.size(); j++){
                if(list.get(j)==0) continue;
                if(lost[i]==list.get(j)-1||lost[i]==list.get(j)+1){
                    answer++;
                    list.set(j,0);
                    lost[i] = 0;
                    break;
                } 
            }
        }
        
        return n-(lost.length-answer);
    }
}