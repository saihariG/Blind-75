import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
    
    // Time Complexity : O(n) ; Space Complexity : O(n)
    public int lengthOfLongestSubstring(String s) {
        
        int size = s.length();
        Set<Character> hashSet = new HashSet<>();

        // Two pointer approach
        int left = 0;
        int longestSubstring = 0;

        for(int right = 0 ; right < size ; right++) {
            
            // traversing until we find a duplicate
            while(hashSet.contains(s.charAt(right))) {
                // if we find a duplicate, remove it from set & increment left pointer
                hashSet.remove(s.charAt(left));
                left++;
            }

            hashSet.add(s.charAt(right));
            longestSubstring = Math.max(longestSubstring, hashSet.size());
        }

        return longestSubstring;
    }
}
