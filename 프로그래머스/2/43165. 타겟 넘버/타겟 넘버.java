class Solution {
    public int solution(int[] numbers, int target) {
        
        return dfs(0,0,numbers,target);
    }
    
    public int dfs(int idx, int sum,int[] numbers, int target){
        if(idx==numbers.length){
            if(sum==target) return 1;
            else return 0;
        }
        int plus = dfs(idx+1, sum+numbers[idx],numbers, target);
        int minus = dfs(idx+1, sum-numbers[idx], numbers, target);
        return plus+minus;
    }
}