public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int longest = 0;
        int[] hash = new int[26];

        int n = s.length();
        
        int maxFrequency = 0;
        int left = 0;

        // Intuition: 
        // find the number of characters in the current window that needs to be replaced
        // replaceCount = currWindowSize - count of most frequent character 
        for(int right = 0 ; right < n ; right++) {

            char currChar = s.charAt(right);
            hash[currChar - 'A']++;
            int currCharacterFreq = hash[currChar - 'A'];

            maxFrequency = Math.max(currCharacterFreq, maxFrequency);

            while((right - left + 1) - maxFrequency > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}