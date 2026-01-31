public class DecodeWays {

    public int numDecodings(String s) {
        
        int n = s.length();
        int[] ways = new int[n+1];

        ways[0] = 1;
        ways[1] = (s.charAt(0) == '0') ? 0 : 1;

        // ways to decode i = ways to decode [i-1] (if new single digit is valid) + 
        // ways to decode [i-2] (if new last 2 digits are valid)
        for(int i = 2 ; i <= n ; i++) {

            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigit = Integer.valueOf(s.substring(i-2, i));

            if(oneDigit >= 1) ways[i] += ways[i-1];

            if(twoDigit >= 10 && twoDigit <= 26) ways[i] += ways[i-2];
        }

        return ways[n];
    }
    
}
