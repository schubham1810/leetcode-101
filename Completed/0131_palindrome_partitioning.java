class Solution {

    private boolean isPalindrome(String s, int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }

    private void generate(int ind, String s, List<String> curr, List<List<String>> result){
        if(ind==s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s,ind, i)){
                curr.add(s.substring(ind,i+1));
                generate(i+1, s,curr, result);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        generate(0,s,new ArrayList<>(),result);
        // System.out.println(result);
        return result;
    }
}