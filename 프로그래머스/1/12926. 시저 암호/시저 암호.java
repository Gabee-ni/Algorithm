import java.util.*;
import java.io.*;
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' ') {
                sb.append(' ');
            } else if (c >= 'a' && c <= 'z') {
                sb.append((char)((c + n - 'a')%26+'a'));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char)((c + n - 'A')%26+'A'));
            }
        }
        
        return sb.toString();
    }
}