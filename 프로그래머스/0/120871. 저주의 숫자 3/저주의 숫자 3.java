class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt =1;
        int useCnt =0;
        
        if(n<=2) return n;
        
        for(int i=3; i<=n; i++){
            while((i+cnt)%3==0 || ((i+cnt)+"").contains("3")){
                cnt++; useCnt=0;
                useCnt++;
            }
            if(useCnt==2) cnt++;
            answer = i+cnt;
        }
        
        return answer;
    }
}