class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] str = { "aya", "ye", "woo", "ma"};
    
        for(String b : babbling){
            for(int i=0; i<str.length; i++){
                b = b.replace(str[i], " ");
            }
            String[] s = b.split(" ");
            if(s.length==0) answer++; 
            System.out.println(b);
        }
        return answer;
    }
}