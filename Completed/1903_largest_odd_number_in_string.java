class Solution {
    public String largestOddNumber(String nums) {
        // char[] c = num.toCharArray();
        // String ans = "";
        // String even = "";
        // for(char i : c){
        //     if(Integer.parseInt(String.valueOf(i))%2 == 1){
        //         ans = ans + even + i;
        //         even = "";
        //     }else{
        //         even += i;
        //     }
        // }
        // return ans;

        int a=nums.lastIndexOf('1');
        a=Math.max(nums.lastIndexOf('3'),a);
        a=Math.max(nums.lastIndexOf('5'),a);
        a=Math.max(nums.lastIndexOf('7'),a);
        a=Math.max(nums.lastIndexOf('9'),a);
        if(a==-1)
            return "";
        return nums.substring(0,a+1);
    }
}