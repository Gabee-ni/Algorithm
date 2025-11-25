import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int rowLen =arr1.length;
        int colLen= arr2[0].length; 
        int sameLen = arr1[0].length;
       
        int[][] answer = new int[rowLen][colLen];
        for(int i=0; i< rowLen ; i++){
            for(int j=0; j< colLen ; j++){
                int total = 0;
                for(int k=0;k<sameLen ; k++){
                    total += (arr1[i][k] * arr2[k][j]);
                }
                answer[i][j] = total;
            }
        }
       
        return answer;
    }
}