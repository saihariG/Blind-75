public class LongestPalindromicSubstring {
    
    private int maxLength = Integer.MIN_VALUE;
    private String result = "";

    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public String longestPalindrome(String s) {

        if(s.length() < 2) return s;

        for(int left = 0 ; left < s.length() ; left++) {

            // assuming odd length and try to expand the palindrome
            expandPalindrome(s, left, left);
            // assuming even length
            expandPalindrome(s, left, left+1);
        }

        return result;
    }

    private void expandPalindrome(String s, int left, int right) {

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            
            if((right - left + 1) > maxLength) {
                maxLength = right - left + 1;
                result = s.substring(left, right+1);
            }

            left--;
            right++;
        }
    }
}
