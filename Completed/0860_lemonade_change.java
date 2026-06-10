class Solution {
    public boolean lemonadeChange(int[] bills) {
        int note5 = 0;
        int note10 = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                note5++;
            }else if(bills[i]==10){
                if(note5==0) return false;
                else{
                    note10++;
                    note5--;
                }
            }else{
                if(note10>=1 && note5>=1){
                    note10--;
                    note5--;
                }else if(note5>=3){
                    note5-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}