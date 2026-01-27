import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
    
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;
        HashMap<Integer, Integer> count = new HashMap<>();

        List<Integer>[] freq = new List[n+1]; // array of List of Integer Data Type

        // storing the count in map
        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // [ List(), List(), ..... n+1 ]
        // each slot holds a list of integer
        // initializing the null values
        for(int i = 0 ; i < freq.length ; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            freq[frequency].add(number);
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = freq.length - 1 ; i > 0 ; i--) {
            for(int num: freq[i]) {
                result[index++] = num;
                if(index == k) return result;
            }
        }

        return result;
    }
}
