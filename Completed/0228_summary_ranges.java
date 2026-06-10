class Solution {
    public List<String> summaryRanges(int[] nums) {
        int end=0;
        int start=0;
        List<String> res = new ArrayList<>();
        if(nums.length==0) return res;
        while(end<nums.length-1){
            if(end+1<nums.length && nums[end+1]!= nums[end]+1){
                String s;
                if(start==end){
                    s =  String.valueOf(nums[start]);
                }else{
                    s =  String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]);
                }
                res.add(s);
                start=end+1;
            }
            end++;
        }
        String s;
        if(start==end){
            s =  String.valueOf(nums[start]);
        }else{
            s =  String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]);
        }
        res.add(s);
        return res;
    }
}