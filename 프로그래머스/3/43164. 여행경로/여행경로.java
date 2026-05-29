import java.util.*;
class Solution {
    String[] answer; 
    boolean[] visited; 
    boolean found = false; 
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a,b) -> {
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]); 
        });
        
        visited= new boolean[tickets.length];
        
        List<String> route = new ArrayList<>(); 
        route.add("ICN"); 
        
        dfs("ICN", tickets, route, 0); 
        
        return answer;
    }
    
    public void dfs(String cur, String[][] tickets, List<String> route, int usedCnt){
        if(found) return; 
        
        if(usedCnt == tickets.length) {
            answer = route.toArray(new String[0]);
            found = true; 
            return; 
        }
        
        for(int i=0; i< tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(cur)){
                visited[i] = true; 
                route.add(tickets[i][1]);
                
                dfs(tickets[i][1], tickets, route, usedCnt+1); 
                
                if(found) return;
                
                visited[i] = false; 
                route.remove(route.size()-1);
            }
        }
    }
}