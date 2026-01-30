package Greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        int goal = n-1;

        // Intuition: Which positions will eventually reach the end
        // Then move backwards to see if earlier positions can reach those positions
        // Then adjust the goal likewise
        for(int i = n-1 ; i >= 0 ; i--) {
        
            if(i + nums[i] >= goal) {
                goal = i;
            }
        }

        return (goal == 0) ? true : false;
    }
}
