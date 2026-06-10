class Solution {

    private void generateSubsets(int[] nums, List<List<Integer>> result, List<Integer> curr, int ind){
        result.add(new ArrayList<>(curr));

        for(int i=ind; i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;

            curr.add(nums[i]);
            generateSubsets(nums,result,curr,i+1);
            curr.remove(curr.size()-1);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(nums,result,curr,0);
        return result;
    }
}