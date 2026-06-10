class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                st.push(arr[i]);
            }else{
                int abs = Math.abs(arr[i]);
                boolean flag = true;
                while(!st.isEmpty() && st.peek()<=abs && st.peek() >0){
                    if(abs == st.peek()) flag= false;
                    st.pop();
                    if(!flag) break;
                }

                if(flag && (st.isEmpty() || st.peek()<0)) st.push(arr[i]);                
            }
        }

        int n = st.size();
        int[] result = new int[n];
        for(int i = n-1;i>=0;i--){
            result[i] = st.pop();
        }
        return result;
    }
}