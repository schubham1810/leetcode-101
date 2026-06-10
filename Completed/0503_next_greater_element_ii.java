class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();

        int[] nums2 = new int[2*nums.length];

        for(int i=0;i<nums2.length;i++){
            int j= i%(nums.length);
            nums2[i] = nums[j];
        }

         int[] result = new int[nums.length];
        for(int i=nums2.length -1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            
            if(i<nums.length){
                if(st.isEmpty()) result[i] = -1;
                else result[i] = st.peek();
            }
            st.push(nums2[i]);
        }

        return result;
    }
}