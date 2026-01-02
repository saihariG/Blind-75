public class SearchInRotatedSortedArray {
    
    public int searchTarget(int[] nums, int target) {

        int n = nums.length;

        int left = 0;
        int right = n-1;

        while(left <= right) {

            int mid = (left + right) / 2;            

            if(target == nums[mid]) {
                return mid;
             }
            
            // check which portion of the array are we in
            if(nums[left] <= nums[mid]) {
                // left sorted portion
                if(target > nums[mid] || target < nums[left]) {
                    // if the target is greater than the middle or 
                    // if the target is less than the left most value
                    // then we have to search the right portion   
                    left = mid + 1; 
                } else {
                    right = mid - 1;
                }
            } else {  
                // right sorted portion 
                if(target < nums[mid] || target > nums[right]) {
                    // search the left portion of the array
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
        }
        
        return -1;
    }
}
