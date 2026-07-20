import java.util.*; 

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> queue = new ArrayDeque<>(); 
        
        for(int i=0; i<s.length(); i++){
            queue.offer(s.charAt(i));
        }
        
        for(int i=0; i<s.length(); i++){
            if(isCorrect(queue)){
                answer++; 
            }
            if(!queue.isEmpty()) queue.offer(queue.poll()); 
        }
        return answer;
    }
    
    public boolean isCorrect(Deque<Character> queue){
        Stack<Character> stack = new Stack<>(); 
        for(Character c : queue){
            if (c == '}'){
                if(!stack.isEmpty() && stack.peek()=='{'){
                    stack.pop(); 
                } else stack.push(c); 
            } else if(c == ']'){
                if(!stack.isEmpty() && stack.peek()=='['){
                    stack.pop(); 
                } else stack.push(c); 
            } else if(c == ')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop(); 
                } else stack.push(c); 
            } else stack.push(c);
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
}