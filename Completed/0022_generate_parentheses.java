class Solution {

    public void generate(List<String> result, int l, int r, int n,String s){
        if(l==n && r ==n){
            result.add(s);
            return;
        }
        if(l>r){
            String s1 = s.concat(")");
            generate(result,l,r+1,n,s1);
        }
        if(l<n){
            String s2 = s.concat("(");
            generate(result,l+1,r,n,s2);
        }
    }

    public List<String> generateParenthesis(int n) {
        String s = "(";
        List<String> result = new ArrayList<>();
        generate(result,1,0,n,s);
        return result;
    }
}