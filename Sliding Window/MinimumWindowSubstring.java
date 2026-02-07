public class MinimumWindowSubstring {
    
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || t.isEmpty()) return "";

        String result = "";

        // ASCII
        int[] hash1 = new int[128];
        int[] hash2 = new int[128];

        for(int i = 0 ; i < t.length() ; i++) {
            char ch = t.charAt(i); 
            hash2[ch]++;
        }

        // Sliding window approach
        int left = 0;
        
        int have = 0, needed = 0;
        // computing the needed value
        for(int i = 0 ; i < 128 ; i++) {
            if(hash2[i] > 0) {
                needed++;
            }
        }

        int minLength = Integer.MAX_VALUE;

        for(int right = 0 ; right < s.length() ; right++) {

            // Update the hash in the current window and compare with the needed hash
            char ch = s.charAt(right);
            hash1[ch]++;

            if(hash1[ch] == hash2[ch]) {
                have++;
            }

            while(have == needed) {
                // We have found a substring
                int currLength = right - left + 1;
                // Update the result string
                if(currLength < minLength) {
                    result = s.substring(left, right+1);
                    minLength = currLength;
                }

                char leftChar = s.charAt(left);
                // Pop from the left of window
                hash1[leftChar]--;

                if(hash1[leftChar] < hash2[leftChar]) {
                    have--;
                }
                left++;
            }
            
        }

        return (minLength == 0) ? "" : result;
    }
}
