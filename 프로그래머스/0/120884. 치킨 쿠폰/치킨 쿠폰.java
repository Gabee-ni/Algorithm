class Solution {
    public int solution(int chicken) {
        int coupone = chicken; //치킨 수만큼 쿠폰 받음.
        int answer = 0;//서비스치킨 개수 
        
        while(coupone >=10){
            int remain= coupone %10;
            coupone /= 10;
            answer += coupone;//서비스 치킨 시킴
            coupone +=remain; //쿠폰 10장 쓰고 남은 쿠폰
        }
        return answer;
    }
}