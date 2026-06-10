class Solution {

    public int[] nse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            result[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return result;
    }

    public int[] pse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nse = nse(heights);
        int[] pse = pse(heights);  
        int max = heights[0];    
        for(int i=0;i<heights.length;i++){
            int area = (nse[i] - pse[i] - 1) * heights[i];
            if(area>max){
                max= area;
            }
        }
        return max;
    }
}