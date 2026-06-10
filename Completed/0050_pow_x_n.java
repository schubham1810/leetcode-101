class Solution {
    public double pow(double val,double x, long n){
        if(n==0){
            return val;
        }
        if(n%2==0){
            x = x*x;
            n = n/2;
        }else{
            val= val * x;
            n= n-1;
        }
        return pow(val,x,n);
    }
    public double myPow(double x, int n) {
        long power = n;
        if(power<0) power*=(-1);
        double ans = pow(1,x,power);
        if(n<0){
            return (1/ans);
        }else{
            return ans;
        }
    }
}