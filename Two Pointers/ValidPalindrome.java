class Solution {

    public boolean validPalindrome(String s) {
        String phrase = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] chars = phrase.toCharArray();

        int n = phrase.length();
        int i = 0, j = n-1;

        for(i = 0 ; i < j ; i++, j--) {
            if(chars[i] != chars[j]) {
                return false;
            }
        }

        return true;
    }
}