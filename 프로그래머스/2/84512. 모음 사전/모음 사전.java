class Solution {
    public int solution(String word) {
        int answer = 0;
        
        int[] weight = {781, 156, 31, 6, 1}; 
        
        String str = "AEIOU"; 
        
        for(int i=0; i<word.length(); i++){
            int idx = str.indexOf(word.charAt(i)); 
            answer += idx * weight[i] + 1; 
        }
        
        return answer;
    }
}