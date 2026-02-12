import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {;
        int answer = 0;
        int start =0, end = distance;
        
                                                           Arrays.sort(rocks);
        while (start <= end){
            int remove =0;
            int prev = 0; 
            
            int mid = (start + end)/2;
            for (int r : rocks){
                if ( r - prev < mid){
                    remove++;
                } else {
                    prev = r;
                }
            }
            
            if (distance - prev < mid){
                remove++;
            }
            
            if ( remove <= n){
                answer = mid;
                start = mid +1;
            } else {
                end = mid -1;
            } 
        }
        return answer;
    }
}