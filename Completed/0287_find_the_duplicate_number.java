class Solution {
    public int findDuplicate(int[] nums) {
        // long sum = 0;
        // for(int i=0;i<nums.length;i++){
        //     sum+=nums[i];
        // }
        // long ex = ((nums.length)*(nums.length-1))/2;
        // return (int)(sum-ex);
        HashSet<Integer> hm = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(hm.contains(nums[i])) return nums[i];
            else hm.add(nums[i]);
        }
        return 0;
    }
}