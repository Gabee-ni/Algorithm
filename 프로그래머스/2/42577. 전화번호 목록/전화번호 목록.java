import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        Map<Integer,String> map = new HashMap<>();
        
        String key = phone_book[0];
        for(int i=1;i<phone_book.length ;i++){
            if(phone_book[i].startsWith(key)) return false;
            else key = phone_book[i];
        }

        return true;
    }
}