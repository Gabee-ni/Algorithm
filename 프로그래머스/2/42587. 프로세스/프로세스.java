import java.util.*; 

class Solution {
    static class Pos {
        int idx; 
        int priority;
        
        Pos(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        Deque<Pos> queue = new ArrayDeque<>(); 
        
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Pos(i,priorities[i]));
        }
        
        int cnt = 0;
        while(!queue.isEmpty()){
            Pos cur = queue.poll(); 
            boolean isMax = false; 
            
            for(Pos pos : queue){
                if(pos.priority > cur.priority){
                    isMax = true;
                    break;
                }
            }
            
            if(isMax) queue.offer(cur);
            else {
                cnt++; 
                if(cur.idx == location) return cnt;
            }
        }
        return 0;
    }
}