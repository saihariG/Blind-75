public class ClimbingStairs {
    public int climbStairs(int n) {

        // For n=1, number of ways = 1
        // For n=2, number of ways = 2
        // For n=3, number of ways = 3

        // Intuition:
        // Similarly, for n=4, If we climb 1 stair, we will have 3 more stairs
        // which is the case for n=3

        // Fibonacci sequence states that "each number is the sum of the two preceding ones, starting from 0 and 1"
        // f(n) = f(n-1)+f(n-2)

        // constraints: 1 <= n <= 45
        int[] ways = new int[46];
        
        ways[1] = 1;
        ways[2] = 2;
        
        for(int i = 3 ; i < 46 ; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }
        
        return ways[n];
    }
}
