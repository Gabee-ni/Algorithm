import java.util.*;
class Solution {
    public String solution(String s) {
        String[] str = s.split(" ",-1);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length;i++){
            String[] ch = str[i].split("");
            for(int j=0; j<ch.length;j++){
                if(j%2==0) sb.append( ch[j].toUpperCase());
                else  sb.append(ch[j].toLowerCase());      
            }
            if(i==str.length-1) break;
            sb.append(" ");
            
        }
        return sb.toString();
    }
}