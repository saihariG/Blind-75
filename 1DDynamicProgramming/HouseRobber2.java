import java.util.Arrays;

public class HouseRobber2 {

    public int rob(int[] nums) {
        int n = nums.length;

        int[] arr = Arrays.copyOf(nums, nums.length);
        
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return max(nums[0], nums[1]);
        
        int loot1 = maxLoot(nums, 2, n-1, false); // skips last house
        int loot2 = maxLoot(arr, 3, n, true); 

        return max(loot1, loot2);
    } 

    static int maxLoot(int[] nums, int low, int high, boolean skipFirstHouse) {
        
        int n = nums.length;

        if(!skipFirstHouse) {
            nums[1] = max(nums[1], nums[0]);
        } else {
            nums[2] = max(nums[2], nums[1]);
        }

        // loot at ith house = max(loot at i-2th house + loot at ith house, loot at i-1th house)
        for(int i = low ; i < high ; i++) {
            int currLoot = max(nums[i-2]+nums[i], nums[i-1]);
            nums[i] = currLoot;
        }
        
        return (skipFirstHouse) ? nums[n-1] : nums[n-2];
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}