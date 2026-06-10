class Solution {
    public int subarraySum(int[] nums, int k) {
        int currentSum=0;
        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        int count=0;
        prefixSum.put(currentSum,1);
        for(int i=0;i<nums.length;i++){
            currentSum += nums[i];
            int rem = currentSum - k;
            if(prefixSum.containsKey(rem)){
                count+= prefixSum.get(rem);
            }
            if(prefixSum.containsKey(currentSum)){
                prefixSum.replace(currentSum,prefixSum.get(currentSum)+1);
            }else{
                prefixSum.put(currentSum,1);
            }
        }
        return count;
    }
}