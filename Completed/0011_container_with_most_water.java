class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = Integer.MIN_VALUE;
        while(l<r){
           int h = Math.min(height[l],height[r]);
           int w = r-l;
           if(h == height[l]) l++;
           else r--;
            max = Math.max(max, (h*w));
        }
        return max;
    }
}