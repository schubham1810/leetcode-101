class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int product = 1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroCount++;
                if(zeroCount>1){
                    product = 0;
                    break;
                }else{
                    continue;
                }
            }
            product*=nums[i];
        }

        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0) res[i]=product;
            else if(zeroCount>0) res[i]=0;
            else res[i]=(product/nums[i]);
        }
        return res;
    }
}