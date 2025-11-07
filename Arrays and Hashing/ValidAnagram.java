class Solution {

    public boolean isValidAnagram(String s, String t) {

        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        for(char c: s.toCharArray()) {
            hash1[c-'a']++;
        }

        for(char c: t.toCharArray()) {
            hash2[c-'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(hash1[i] != hash2[i]) {
                return false;
            }
        }

        return true;
    }

}