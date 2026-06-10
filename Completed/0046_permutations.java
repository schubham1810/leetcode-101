class Solution {
    public void func(int[] nums, int index, List<List<Integer>> ans){
        if(nums.length-1 == index){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }

        for(int i= index; i<nums.length;i++){
            swap(i,index,nums);
            func(nums,index+1,ans);
            swap(i,index,nums);
        }
    }
    public void swap(int i, int j,int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        func(nums,0,ans);
        return ans;
    }
}