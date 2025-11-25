import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = null;
        int rowLen =0, colLen=0, sameLen=0;
        if(arr1[0].length==arr2.length) {
            sameLen = arr1[0].length;
            rowLen = arr1.length;
            colLen = arr2[0].length;
            
            answer = new int[rowLen][colLen];
            for(int i=0; i< rowLen ; i++){
                for(int j=0; j< colLen ; j++){
                    int total = 0;
                    for(int k=0;k<sameLen ; k++){
                        total += (arr1[i][k] * arr2[k][j]);
                    }
                    answer[i][j] = total;
                }
            }
        }else if(arr1.length==arr2[0].length){
            sameLen = arr1.length;
            rowLen = arr2.length;
            colLen = arr1[0].length;
            
            answer = new int[rowLen][colLen];
            for(int i=0; i< rowLen ; i++){
                for(int j=0; j< colLen ; j++){
                    int total = 0;
                    for(int k=0;k<sameLen ; k++){
                        total += (arr1[k][j] * arr2[i][k]);
                    }
                    answer[i][j] = total;
                }
            }
        }
        return answer;
    }
}