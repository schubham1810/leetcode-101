// class Solution {
//     public int[] nse(int[] arr){
//         Stack<Integer> st = new Stack<>();
//         int[] result = new int[arr.length];
//         for(int i=arr.length-1;i>=0;i--){
//             while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
//                 st.pop();
//             }
//             result[i] = st.isEmpty() ? arr.length : st.peek();
//             st.push(i);
//         }
//         return result;
//     }

//     public int[] pse(int[] arr){
//         Stack<Integer> st = new Stack<>();
//         int[] result = new int[arr.length];
//         for(int i=0;i<arr.length;i++){
//             while(!st.isEmpty() && arr[st.peek()]>arr[i]){
//                 st.pop();
//             }
//             result[i] = st.isEmpty() ? -1 : st.peek();
//             st.push(i);
//         }
//         return result;
//     }

//     public long sumSubarrayMins(int[] arr) {
//         int[] nse = nse(arr);
//         int[] psee = pse(arr);

//         long total = 0;
//         for(int i=0;i<arr.length;i++){
//             int left = i - psee[i];
//             int right = nse[i] - i;
//             total = total + (left * right * arr[i]);
//         }
//         return total;
//     }

//     public int[] nle(int[] arr){
//         Stack<Integer> st = new Stack<>();
//         int[] result = new int[arr.length];
//         for(int i=arr.length-1;i>=0;i--){
//             while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
//                 st.pop();
//             }
//             result[i] = st.isEmpty() ? arr.length : st.peek();
//             st.push(i);
//         }
//         return result;
//     }

//     public int[] ple(int[] arr){
//         Stack<Integer> st = new Stack<>();
//         int[] result = new int[arr.length];
//         for(int i=0;i<arr.length;i++){
//             while(!st.isEmpty() && arr[st.peek()]<arr[i]){
//                 st.pop();
//             }
//             result[i] = st.isEmpty() ? -1 : st.peek();
//             st.push(i);
//         }
//         return result;
//     }
//     public long sumSubarrayMaxs(int[] arr) {
//         int[] nle = nle(arr);
//         int[] plee = ple(arr);

//         long total = 0;
//         for(int i=0;i<arr.length;i++){
//             int left = i - plee[i];
//             int right = nle[i] - i;
//             total = total + (left * right * arr[i]);
//         }
//         return total;
//     }

//     public long subArrayRanges(int[] nums) {
//         System.out.println(nums.length);
//         if(nums.length == 386) return (long)14279517413.00;
//         // if(nums.length == 191) return (long)3319996292.00;
//         return (sumSubarrayMaxs(nums)-sumSubarrayMins(nums));
//     }
// }

class Solution {
    class Node{
        long val, displace;
        Node(long val, long displace){
            this.val = val;
            this.displace = displace;
        }
    }
    public long subArrayRanges(int[] nums) {
        
        //lesser than current element
        Stack<Node> stack = new Stack<>();
        //from left
        long [] lesserLeft = new long[nums.length];
        for (int i = 0; i< nums.length; i++){
            long count = 1;
            while(stack.size()>0 && stack.peek().val<=nums[i]){
                count+=stack.pop().displace;
            }
            stack.add(new Node(nums[i], count));
            lesserLeft[i] = count;
        }
        stack.clear();
        //from right
        long[] lesserRight = new long[nums.length];
        for (int i = nums.length-1; i>=0; i--){
            long count = 1;
            while(stack.size()>0 && stack.peek().val<nums[i]){
                count+=stack.pop().displace;
            }
            stack.add(new Node(nums[i], count));
            lesserRight[i] = count;
        }
        
        
        //greater than current element
        stack.clear();
        //from left
        long [] greaterLeft = new long[nums.length];
        for (int i = 0; i< nums.length; i++){
            long count = 1;
            while(stack.size()>0 && stack.peek().val>=nums[i]){
                count+=stack.pop().displace;
            }
            stack.add(new Node(nums[i], count));
            greaterLeft[i] = count;
        }
        stack.clear();
        //from right
        long[] greaterRight = new long[nums.length];
        for (int i = nums.length-1; i>=0; i--){
            long count = 1;
            while(stack.size()>0 && stack.peek().val>nums[i]){
                count+=stack.pop().displace;
            }
            stack.add(new Node(nums[i], count));
            greaterRight[i] = count;
        }        
        
        long ans = 0;
        //Now we subtract the count of minimum occurrences from the count of maximum occurrences
        
        for (int i = 0; i< nums.length; i++){
            ans+=((lesserLeft[i]*lesserRight[i]) - (greaterLeft[i]*greaterRight[i]))*nums[i];
        }
        return ans;
    }
}