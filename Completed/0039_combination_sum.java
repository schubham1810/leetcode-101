class Solution {

    private void generate(int i, int target, List<List<Integer>> result, List<Integer> res, int[] arr){
        if(i==arr.length){
            if(target==0){
                result.add(new ArrayList<>(res));
            }
            return;
        }
        if(arr[i]<=target){
            res.add(arr[i]);
            generate(i,target-arr[i],result,res,arr);
            res.remove(res.size()-1);
        }

        generate(i+1,target,result,res,arr);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        generate(0,target,result,arr,candidates);
        return result;
    }
}