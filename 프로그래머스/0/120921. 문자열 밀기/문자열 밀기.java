import java.util.*;
class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        String[] arrA = A.split("");

        List<String> list = new  LinkedList<>();
        for(String s : arrA){
            list.add(s);
        }
        
        if(A.equals(B)) return 0;
        
        for(int i=0; i<list.size(); i++){
            String num = list.get(list.size()-1);
            list.remove(list.size()-1);
            ((LinkedList<String>)list).addFirst(num);
            String str = String.join("", list);
            if(str.equals(B)) {
                answer++;
                break;
            }
            else answer ++;
            
            if(i==(list.size()-1) && answer>= list.size()) answer=0; 
        }
        return (answer==0)? -1:answer ;
    }
}