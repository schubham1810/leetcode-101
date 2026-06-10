class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        long sum =0;
        int l,k;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                k=j+1;
                l=n-1;
                while(k<l){
                    sum =(long)  nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum==target){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        resultList.add(list);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }else if(sum<target) k++;
                    else l--;
                }
            }
        }
        return resultList;
    }
}