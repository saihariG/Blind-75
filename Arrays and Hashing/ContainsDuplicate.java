class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set set = new HashSet<>();

        for(int num : nums) {

            if(set.contains(num)) {
                return true;
            }
            
            set.add(num);
        }

        return false;
    }
}

public class Main {

    public static void Main(String[] args) {

    }
}