import java.util.*;
class Solution {
    public int solution(String before, String after) {
        String[] afterArr = after.split("");
        String[] beforeArr = before.split("");
        
        Arrays.sort(afterArr);
        Arrays.sort(beforeArr);
        
        for(int i=0;i<afterArr.length;i++){
            if(!afterArr[i].equals(beforeArr[i])) return 0;
        }
        return 1;
    }
}