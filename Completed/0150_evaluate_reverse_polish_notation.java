class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                Integer s1 = Integer.valueOf(st.pop());
                Integer s2 = Integer.valueOf(st.pop());
                Integer s;
                switch(tokens[i]){
                    case "+":
                        s = s2+s1;
                        break;
                    case "-":
                        s = s2-s1;
                        break;
                    case "*":
                        s = s2*s1;
                        break;
                    case "/":
                        s = s2/s1;
                        break;
                    default:
                        s = 0;
                }

                st.push(String.valueOf(s));
            }else{
                st.push(tokens[i]);
            }
        }
        return Integer.valueOf(st.peek());
    }
}