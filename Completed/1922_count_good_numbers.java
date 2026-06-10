class Solution {
     public long MOD = 1_000_000_007;
    
    public int countGoodNumbers(long n) {
        
        long odd = n/2;
        long even = (n+1)/2;

        return (int)(pow(1,5,even) * pow(1,4,odd) % MOD);
    }
    
    public long pow(long val,long x, long n){
        if(n==0){
            return val;
        }
        if(n%2==0){
            x = (x*x)%MOD;
            n = n/2;
        }else{
            val= (val * x)%MOD;
            n= n-1;
        }
        return pow(val,x,n);
    }
}