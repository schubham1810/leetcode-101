class Solution {

    public String helper(String s){
        char[] arr = s.toCharArray();
        int n = arr.length;
        char curr = arr[0];
        int currCount = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n;i++){
            if(curr==arr[i]){
                currCount++;
            }else{
                sb.append(currCount);
                sb.append(curr);
                curr = arr[i];
                currCount = 1;
            }
        }
        sb.append(currCount);
        sb.append(curr);
        return sb.toString();
    }

    public String rle(String s, int n){
        if(n==1) return s;

        return rle(helper(s),--n);
    }
    public String countAndSay(int n) {
        return rle("1", n);
    }
}