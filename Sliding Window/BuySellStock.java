class BuySellStock {

    public int maxProfit(int[] prices) {
        int i = 0;
        int maxProfit = 0;
        
        for(int j = i+1 ; j < prices.length ; j++) {

            // Profitable ?
            if(prices[j] > prices[i]) {
                int currProfit = prices[j] - prices[i];
                
                if(currProfit > maxProfit) {
                    maxProfit = currProfit;
                }
            }
            else {
                i = j;
            }
        }

        return maxProfit;
    }

}