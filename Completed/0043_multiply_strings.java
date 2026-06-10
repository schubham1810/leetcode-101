class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];
        int k=0;
        for(int i = m-1;i>=0;i--){
            for(int j = n-1; j>=0; j--){
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                mul+= res[i+j+1];

                res[i+j+1] = mul%10;
                res[i+j]+= mul/10;

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r : res) {
            if (sb.length() == 0 && r == 0) {
                continue;
            }
            sb.append(r);
        }

        return sb.toString().equals("") ? "0": sb.toString();
    }
}