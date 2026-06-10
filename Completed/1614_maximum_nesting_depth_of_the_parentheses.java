class Solution {
    public int maxDepth(String s) {
        int counter = 0;
        int max =0;
        for(char c : s.toCharArray()){
            if(c == '(') counter++;
            else if(c== ')') counter --;

            max= Math.max(max, counter);
        }
        return max;
    }
}