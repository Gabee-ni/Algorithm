class Solution {
public static int cnt=0;
    public int solution(int[] numbers, int target) {
        int answer = dfs(0,0,0,numbers,target);
        return answer;
    }
    
    public int dfs(int node, int num, int idx, int[] numbers, int target){
        if(node==numbers.length){
            if(num==target) return cnt ++;
            else return cnt;
        }
        dfs(node+1, num+numbers[idx], idx+1, numbers, target);
        dfs(node+1, num-numbers[idx], idx+1, numbers, target);
        return cnt;
    }
}