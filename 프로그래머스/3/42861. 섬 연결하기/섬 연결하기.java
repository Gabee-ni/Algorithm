import java.util.*;

class Solution {
    static class Edge{
        int s; 
        int e;
        int cost;
        
        Edge(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
    static int[] parent;
    static int[] rank;
    
    // find 함수
    public int find (int node){
        if(parent[node]==node) return node; 
        return parent[node] = find(parent[node]);
    }
    
    
    // union 함수
    public boolean union (int s, int e){
        int ps = find(s); 
        int pe = find(e);
        
        if(ps == pe) return false; 
        
        if(rank[ps] > rank [pe]) parent[pe] = ps;
        else if(rank[ps] < rank[pe]) parent[ps] = pe; 
        else {
            parent[ps] = pe; 
            rank[pe] ++; 
        }
        
        return true;
    }
    
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        List<Edge> graph = new ArrayList<>();
        for(int[] c : costs){
            graph.add(new Edge(c[0],c[1],c[2]));
        }
        
        Collections.sort(graph, (a,b)-> {
           return a.cost - b.cost; 
        });
        
        parent = new int[n];
        rank = new int[n];
        
        for(int i =0; i<n ;i++){
            parent[i] =i;
        }
        
        int totalCost = 0; 
        int used = 0; 
        
        for (Edge e : graph ){
            if(union(e.s, e.e)){
                totalCost += e.cost; 
                used++; 
                
                if(used == n-1) break;
            }
        }

        
        return totalCost;
    }
}