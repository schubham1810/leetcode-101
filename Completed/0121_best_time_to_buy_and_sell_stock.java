class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
		int low = prices[0];
		
		for(int i=1;i<prices.length;i++) {
			if(prices[i]<low) low = prices[i];
			int p = prices[i]-low;
			maxP = Math.max(maxP, p);
		}
		
		return maxP;
    }
}