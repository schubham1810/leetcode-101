class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int max =0;
        char[] arr = s.toCharArray();
        Map<Character,Integer> charCount = new HashMap<>();
        int maxFreq = 0;
        for(int r = 0;r< arr.length; r++){
            charCount.put(arr[r],charCount.getOrDefault(arr[r],0)+1);
            maxFreq = Math.max(maxFreq, charCount.get(arr[r]));
            int len = r-l+1;
            if(len-maxFreq>k){
                charCount.put(arr[l],charCount.get(arr[l])-1);
                l++;
                maxFreq = 0;
                continue;
            }
            
                max = Math.max(max,(r-l+1));
            
        }
        return max;
    }
}