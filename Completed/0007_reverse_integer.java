class Solution {
    public int reverse(int x) {
        int i = x>-1? x: x*(-1);
        int rev = 0;
        try{
            while(i>0){
                int temp = i%10;
                if(rev>(Integer.MAX_VALUE - temp)/10){
                    return 0;
                }
                rev = (rev*10) + temp;
                i= i/10;
            }
            return x>-1? rev:rev*(-1);
        }catch(NumberFormatException e){
            return 0;
        }
    }
}