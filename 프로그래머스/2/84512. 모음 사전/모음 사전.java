class Solution {
    String[] str = {"A","E", "I", "O","U"};
    int count = 0, answer =0;
    
    public int solution(String word) {
        dfs("", word); 
        
        return answer;
    }
    
    public void dfs (String s, String word){
        if(s.equals(word)){
            answer = count ; 
            return;
        }
        
        if(s.length() ==5){
            return;
        }
        
        for(int i=0; i<str.length; i++){
            count++; 
            dfs(s + str[i], word); 
        }
    }
}