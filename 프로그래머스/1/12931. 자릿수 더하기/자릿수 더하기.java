import java.util.*;

public class Solution {
    public int solution(int n) {
        String[] str = (n+"").split(""); 
        return Arrays.stream(str).mapToInt(Integer::parseInt).sum();
    }
}