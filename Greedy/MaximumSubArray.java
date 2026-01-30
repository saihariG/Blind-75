package Greedy;

public class MaximumSubArray {

    // kadanes Algorithm
    public int maxSubArray(int[] nums) {
        
        int maxSum = nums[0];
        int currSum = maxSum;
        
        for(int i = 1 ; i < nums.length ; i++) {
            
            if(nums[i] > currSum + nums[i]) {
               currSum = nums[i];    
            }
            else {
               currSum = currSum + nums[i];
            }
            
            if(currSum > maxSum) {
               maxSum = currSum;
            }
        }
        
        return maxSum;
    }
    
}
