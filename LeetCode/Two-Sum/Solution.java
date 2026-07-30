1import java.util.*; 
2class Solution {
3    public int[] twoSum(int[] nums, int target) {
4        for(int i=0; i<nums.length; i++){
5            for(int j=0; j<nums.length; j++){
6                if((i != j) &&(nums[i]+nums[j]) == target) return new int[]{i,j};
7            }
8        }
9        return new int[2];
10    }
11}