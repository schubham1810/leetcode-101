class Solution {

    public void generate(List<List<Integer>> result,List<Integer> arr,int n,int[] nums){
        if(n==nums.length){
            result.add(arr);
            return;
        }
        List<Integer> arr1 = new ArrayList<>(arr);
        generate(result,arr1,n+1,nums);
        List<Integer> arr2 = new ArrayList<>(arr);
        arr2.add(nums[n]);
        generate(result,arr2,n+1,nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =  new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        generate(result,arr,0,nums);
        return result;
    }
}