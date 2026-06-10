class Solution {
    public void profit(int ind, int[] prices, int[] max) {
    	if(ind>=prices.length-1) {
    		max[1] = Math.max(max[1], max[0]);
    		max[0] = 0;
    		return;
    	}
    	int buy = prices[ind];
    	for(int i=ind+1; i<prices.length;i++) {
    		if(prices[i]>buy) {
    			int n = max[0];
    			max[0]+=prices[i]-buy;
    			profit(i+1,prices,max);
    			max[1] = Math.max(max[1], max[0]);
    			max[0]=n;
    		}
    	}
    }
    
    // public int maxProfit(int[] prices) {
    // 	int[] max = new int[] {0,0};
    // 	int maximum=0;
    // 	for(int i=0;i<prices.length;i++) {
    // 		max = new int[] {0,0};
    // 		profit(i,prices,max);
    // 		maximum = Math.max(maximum, max[1]);
    // 	}
    // 	return maximum;
    // }

    public int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1]) {
            profit += prices[i] - prices[i - 1];
        }
    }
    return profit;
}

}