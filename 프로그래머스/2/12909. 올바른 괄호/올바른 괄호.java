import java.util.*;
class Solution {
    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>(); 
        
        if(s.charAt(0) == ')') return false; 
        
        deque.offer(s.charAt(0));
        
        for(int i=1; i<s.length(); i++){
            if(!deque.isEmpty() && deque.peek() == '('){
                if(s.charAt(i) == ')') deque.poll(); 
                else deque.offer(s.charAt(i)); 
            } else deque.offer(s.charAt(i));
        }
        
        if (deque.isEmpty()) return true; 
        else return false; 
    }
}