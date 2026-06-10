class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        String ans = "";
        for(int i=arr.length-1;i>=0;i--){
            ans += arr[i].trim();
            if(i!=0 && arr[i].trim()!="") ans+= " ";
        }
        return ans;
    }
}