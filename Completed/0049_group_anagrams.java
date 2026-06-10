class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            List<String> list = map.getOrDefault(sortedString, new ArrayList<>()); 
            list.add(strs[i]);                                                  
            map.put(sortedString, list);    
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> arr : map.values()){
            result.add(arr);
        }
        return result;
    }
}