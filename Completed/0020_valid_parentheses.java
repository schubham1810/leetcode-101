class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        for(char c: arr){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                else{
                    char t = stack.pop();
                    if((c==')' && t == '(') || (c=='}' && t == '{') || (c==']' && t == '[')){
                        continue;
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}