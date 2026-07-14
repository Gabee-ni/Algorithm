import java.util.*; 

class Solution {
    static public class BookingTime {
        int startMin; 
        int endMin; 

        BookingTime(int startMin, int endMin){
            this.startMin = startMin; 
            this.endMin = endMin; 
        }
    }
    public int solution(String[][] book_time) {
        PriorityQueue<BookingTime> minHeap = new PriorityQueue<>((a,b)->{
            return a.startMin - b.startMin;
        }); //시작시간 기준
        PriorityQueue<BookingTime> useRoom = new PriorityQueue<>((a,b)->{
            return a.endMin - b.endMin;
        }); //종료시간 기준 
        int answer = 0;
        
        for(String[] time : book_time){
            String[] start = time[0].split(":");
            String[] end = time[1].split(":");
            int startMin = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endMin = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            
            minHeap.offer(new BookingTime(startMin, endMin));
        }
        int room = 0; 
        
        while(!minHeap.isEmpty()){
            BookingTime cur = minHeap.poll(); 

            if(!useRoom.isEmpty() && cur.startMin >= useRoom.peek().endMin+10){
                useRoom.poll(); 
            } 
            useRoom.offer(cur);
            answer = Math.max(answer, useRoom.size());
        }
        return answer;
    }
}