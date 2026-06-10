class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else{
            int rev =0;
            int i= x;
            while(i!=0){
                rev = rev*10 + i%10;
                i /=10;
            }
            return x==rev;
        }
    }
}