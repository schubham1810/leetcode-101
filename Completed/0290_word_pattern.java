class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> revMap = new HashMap<>();
        if(pattern.length()!=arr.length) return false;
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!(map.get(pattern.charAt(i)).equals(arr[i]))) return false;
                // if(revMap.get(arr[i])!=pattern.charAt(i)) return false;
            }else{
                map.put(pattern.charAt(i),arr[i]);
                if(revMap.containsKey(arr[i]) && revMap.get(arr[i])!=pattern.charAt(i)) return false;
                else{
                    revMap.put(arr[i],pattern.charAt(i));
                }
            }
        }
        return true;
    }
}