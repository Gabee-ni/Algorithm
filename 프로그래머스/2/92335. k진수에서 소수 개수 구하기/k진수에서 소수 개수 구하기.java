import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int cnt = 0;
        
        String kNum = Integer.toString(n,k);
        String[] str = kNum.split("0");
        
        for(int i=0; i<str.length; i++) {
            if(str[i].length()<1) continue;
            long num = Long.parseLong(str[i]);
            if(isPrime(num)) cnt++;
        }
        return cnt;
    }
    
    public static boolean isPrime(long num){
        if(num <2) return false;
        for(long i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false; 
        }
        return true;
    }
}