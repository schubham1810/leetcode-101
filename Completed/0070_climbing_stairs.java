class Solution {

    public int func(int ind, int[] dp){
        if(ind<=1) return 1;
        if(dp[ind]!=-1) return dp[ind];

        return dp[ind] = func(ind-1,dp) + func(ind-2,dp);
    }
    public int climbStairs(int n) {
        int prev = 1;
        int prev1 = 1;
        int curr;

        for(int i=2;i<=n;i++){
            curr = prev + prev1;
            prev1 = prev;
            prev = curr;
        }
        return prev;
    }
}