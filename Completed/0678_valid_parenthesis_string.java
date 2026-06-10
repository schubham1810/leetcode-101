class Solution {
    // private boolean check(int i, String s, int count){
    //     if(count<0) return false;
    //     if(i==s.length()) return count==0;

    //     if(s.charAt(i)=='(') return check(i+1,s,count+1);
    //     else if(s.charAt(i)==')') return check(i+1,s,count-1);
    //     else{
    //         return check(i+1,s,count+1) ||  check(i+1,s,count-1) ||  check(i+1,s,count) ;
    //     }
    // }
    public boolean checkValidString(String s) {
    //    return check(0,s,0);
        int min = 0;
        int max = 0;
        for(char c: s.toCharArray()){
            if(c=='('){
                min++;
                max++;
            }else if(c==')'){
                min--;
                max--;
            }else{
                min--;
                max++;
            }
            if(min<0) min=0;
            if(max<0) return false;
        }
        // System.out.println(min+ ","+  max);
        return min==0;
    }
}