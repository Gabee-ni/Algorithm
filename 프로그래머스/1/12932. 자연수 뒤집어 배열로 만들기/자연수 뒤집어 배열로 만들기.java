import java.util.*;
class Solution {
    public int[] solution(long n) {
        String[] str = String.valueOf(n).split("");
        int[] arr = new int[str.length];
        
        for(int i=0; i<str.length; i++){
            arr[i] = Integer.parseInt(str[str.length-(i+1)]); 
        }
        
        return arr; 
    }
}