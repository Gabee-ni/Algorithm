class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int n=i; n<=j ;n++){
            String[] str = (n+"").split("");
            for(int m=0; m<str.length;m++){
                 if(str[m].contains(k+""))answer++;
           }           
        }
        
        return answer;
    }
}