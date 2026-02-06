/* 
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) { 
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sorting the given array

        int n = nums.length;

        for(int i = 0 ; i < n ; i++) {

            // assume this is our number
            int a = nums[i];
            
            // skipping the same number
            if(i > 0 && nums[i-1] == a) continue;
            
            int left = i+1, right = n-1;
            
            while(left < right) {
                int threeSum = a + nums[left] + nums[right];

                if(threeSum == 0) {
                    // we have our triplet 
                    result.add(Arrays.asList(a, nums[left], nums[right]));

                    // adjusting the pointer
                    left++;
                    // skipping duplicates
                    while(nums[left] == nums[left-1]) {
                        left++;
                    }

                } else if(threeSum > 0) {
                    right--;
                } else {
                    left++;
                }

            }

        }
        return result;
    }
}