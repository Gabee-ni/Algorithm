import java.util.*;
class Item {
    public int x; //인덱스
    public  int y; //n과의 차이 
    
    Item(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
}

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        Item[] item = new Item[numlist.length] ;
        
        for(int i=0; i<numlist.length;i++){
            item[i] = new Item(i, Math.abs(n-numlist[i]));
        }
        Arrays.sort(item, (a, b)->{
            if(a.y==b.y) return  numlist[b.x] - numlist[a.x];
            return a.y - b.y;
        });
        
        int idx =0;
        for(Item i : item){
            answer[idx++] = numlist[i.getX()];
            // System.out.print(i.getY());
            
        }
        
        
        return answer;
    }
}

