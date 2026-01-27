public class HouseRobber {
    public int rob(int[] nums) {

        int n = nums.length;

        if(n < 2) return nums[0];

        nums[1] = max(nums[0], nums[1]);

        // loot at ith house = max(loot at i-2th house + loot at ith house, loot at i-1th house)
        for(int i = 2 ; i < n ; i++) {
            int currLoot = max(nums[i-2]+nums[i], nums[i-1]);
            nums[i] = currLoot;
        }

        return nums[n-1];
    }


    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
