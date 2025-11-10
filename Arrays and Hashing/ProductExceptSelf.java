/* Given an integer array nums, 
return an array output where output[i] is the product of all the elements of nums except nums[i]. */

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];
        output[0] = nums[0];

        // storing cumulative multiplication values from left
        for(int i = 1 ; i < nums.length ; i++) {
            output[i] = output[i-1] * nums[i];
        }


        int product = 1;
        // travesing from right and updating the products except the first element in our output array
        for(int i = nums.length-1 ; i > 0 ; i--) {
            output[i] = output[i-1] * product;
            product = product * nums[i];
        }
        output[0] = product;

        return output;
    }
}