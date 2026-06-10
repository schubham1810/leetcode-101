class Solution {
    private void generate(int i, int k, int target, List<List<Integer>> result, List<Integer> res, int[] arr){
        if(i==arr.length){
            if(target==0 && res.size()==k){
                result.add(new ArrayList<>(res));
            }
            return;
        }
        if(arr[i]<=target){
            res.add(arr[i]);
            generate(i+1,k,target-arr[i],result,res,arr);
            res.remove(res.size()-1);
        }

        generate(i+1,k,target,result,res,arr);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        generate(0,k,n,result,arr,candidates);
        return result;
    }
}