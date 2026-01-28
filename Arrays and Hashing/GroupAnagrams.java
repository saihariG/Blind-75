import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        // mapping the character count of each string and the
        // list of strings that has the same character count 
        Map<String, List<String>> map = new HashMap<>();

        for(String word: strs) {
            int[] hash = getCharacterHash(word);
            String key = Arrays.toString(hash);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        
        return new ArrayList<>(map.values());
    }

    static int[] getCharacterHash(String word) {
        int[] hash = new int[26];

        for(int i = 0 ; i < word.length() ; i++) {
            char c = word.charAt(i);
            hash[c - 'a']++;
        }

        return hash;
    }
}
