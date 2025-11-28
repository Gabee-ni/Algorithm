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

        
        // //최대공약수나, 그 수의 약수들(최대공약수%i==0) 중에 조건을 만족하는 가장 큰 수 찾기 
        // for(int i=numA; i>1; i--){
        //     if(numA%i==0 && check(arrayB,i)){
        //         answer = Math.max(answer,i);
        //         break;
        //     }
        // }
        // for(int i=numB; i>=1; i--){
        //     if(numB%i==0 && check(arrayA,i)){
        //         answer = Math.max(answer,i);
        //         break;
        //     }
        // }
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