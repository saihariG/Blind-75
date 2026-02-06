public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        int left = 0, maxArea = 0;
        int right = heights.length - 1;
        
        // Two pointer approach
        while(left < right) {

            int height = Math.min(heights[left], heights[right]);
            int width = right - left;

            // calculate the current area
            int currArea = width * height;

            // update the maxArea
            maxArea = Math.max(maxArea, currArea);

            // move the pointer that has the smaller height value
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
    
}
