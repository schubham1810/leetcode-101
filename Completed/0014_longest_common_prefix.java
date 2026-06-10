class Solution {
    public int smallestString(String[] arr){
        int a = arr[0].length();
        for(String i: arr){
            if(i.length()<a){
                a = i.length();
            }
        }
        return a;
    }
    public String longestCommonPrefix(String[] strs) {
        int a =  smallestString(strs);
        String ans = "";
        for(int i=0;i<a;i++){
            String temp = strs[0].substring(0,i+1);
            for(int j=0;j<strs.length;j++){
                if(!strs[j].startsWith(temp)){
                    return ans;
                }
            }
            ans = temp;
        }
        return ans;
    }
}