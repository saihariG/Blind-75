import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        int longestSequence = 0;
        Set<Integer> hashSet = new HashSet<>();

        for(int num: nums) {
            hashSet.add(num);
        }

        for(int num: hashSet) {
            // check if this number is the start of a sequence
            if(!hashSet.contains(num-1)) {
                int currSequenceLength = 0;

                // As long as the next number is present in the hashSet, 
                // we are incrementing the length of current sequence
                while(hashSet.contains(num + currSequenceLength)) {
                    currSequenceLength++;
                }

                longestSequence = Math.max(currSequenceLength, longestSequence);
            }
        }

        return longestSequence;
    }
}
