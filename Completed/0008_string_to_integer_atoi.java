class Solution {
    private long evalue(String s, long sum, char sign){
        if(s.length()==0 || s.charAt(0)<48 || s.charAt(0)>57){
            return sum;
        }
        if(sign=='-'){
            sum = sum*10 - Integer.parseInt(String.valueOf(s.charAt(0)));
            if(sum<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }else{
            sum = sum*10 + Integer.parseInt(String.valueOf(s.charAt(0)));
            if(sum>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }  
        return evalue(s.substring(1),sum,sign);
    }
    public int myAtoi(String s) {
        if(s.length()==0) return 0;
        s = s.trim();
        if(s.length()==0) return 0;
        char sign = s.charAt(0);
        if(sign=='-' || sign == '+'){
            s = s.substring(1);
        }else{
            sign = '+';
        }
        if(s.length()==0) return 0;
        long result = evalue(s,0,sign);
        return (int)result;
    }
}