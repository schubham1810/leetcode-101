class Solution {
    public String convert(String t, int numRows) {
        TreeMap<Integer,String> map = new TreeMap<>();
        int add = 1;
        int i = 0;
        if(numRows==1) return t;
        for(char c: t.toCharArray()){
            String s = map.getOrDefault(i,"") + String.valueOf(c);
            map.put(i,s);
            if(i==0) add=1;                
            if(i==numRows-1) add = -1;
            i += add;
        }

        String result = "";
        for(String s: map.values()){
            result = result+ s;
        }
        return result;
    }
}