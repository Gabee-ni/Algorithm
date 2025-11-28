import java.util.*;
class Solution {
    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    
    public boolean check(int[] arr, int num){
        for(int i=0; i<arr.length;i++){
            if(arr[i]%num==0) return false; 
        }
        return true;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int numA = arrayA[0];
        int numB = arrayB[0];
        
        for(int i=1; i<arrayA.length;i++){
            numA = gcd(numA,arrayA[i]);
        }  

        for(int i=1; i<arrayB.length;i++){
            numB = gcd(numB,arrayB[i]);
        }

        if(check(arrayA, numB)){
            answer = (numA>numB)?numA:numB;
            return answer;
        }
        if(check(arrayB, numA)){
            answer = (numA>numB)?numA:numB;
            return answer;
        }
        return answer;
    }
}