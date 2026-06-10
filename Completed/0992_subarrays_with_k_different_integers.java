class Solution {
     private int rubbish(int[] arr, int k){
        int l =0;
        int count = 0;
        Map<Integer,Integer> charMap = new HashMap<>();
        for(int r=0;r<arr.length;r++){
            charMap.put(arr[r],charMap.getOrDefault(arr[r],0)+1);
            
            while(charMap.size()>k){
                charMap.put(arr[l],charMap.get(arr[l])-1);
                if(charMap.get(arr[l])==0){
                    charMap.remove(arr[l]);
                }
                l++;
            }
            if(charMap.size()<=k){
                count+= (r-l+1);
            }
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return rubbish(nums,k)- rubbish(nums,k-1);
    }
}