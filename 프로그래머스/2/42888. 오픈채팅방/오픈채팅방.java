import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String[]> list = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            list.add(record[i].split(" "));
        }
        
        Map<String, String> map = new HashMap<>();
      
        
        for(String[] str : list){
            System.out.println(Arrays.toString(str));
        }
        
        return null;
    }
}