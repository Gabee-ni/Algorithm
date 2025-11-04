import java.util.*;
class Solution {
    public int solution(int a, int b) {
        int num = getGCD(a,b);
        if(num!=1){
            a = a/num;
            b = b/num;
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=2; i<=b ; i++){
            if(isPrime(i)){
               
                if(b%i==0) list.add(i);    
            }
        }
        for(Integer i : list){
            if(i!=2 && i!=5) return 2;
        }
        return 1;
    }
    
    public int getGCD(int a, int b){
        if(b==0) return a;
        return getGCD(b, a%b);
    }
    
    public boolean isPrime(int n){
        if(n <= 1) return false; 
        for(int i=2; i<n ;i++){
            if(n%i==0) return false;
        }
        return true; 
    }
}