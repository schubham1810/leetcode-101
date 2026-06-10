class Solution {
    public boolean isPalindrome(String s) {
        s= s.toLowerCase();
        s= s.replaceAll("[^a-zA-Z0-9]", "");
        char[] str = s.toCharArray();
        for(int i=0;i<s.length()-1;i++){
            if(str[i] != str[s.length()-1-i]){
                return false;
            }
        }
        return true;
    }
}