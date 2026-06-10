// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         Map<String,Integer> map = new HashMap<>();
//         int window = words[0].length() * words.length;
//         int n = words[0].length();
//         int l=0;
//         // int r=window-1;
//         List<Integer> arr = new ArrayList<>();
//         for(int i=0;i<words.length;i++){
//             map.put(words[i], map.getOrDefault(words[i],0)+1);
//         }
//         while(l+window-1<s.length()){
//             // String temp = s.substring(l,l+window);
//             Map<String,Integer> tempMap = new HashMap<>(map);
//             for(int i=l;i<l+window;i+=n){
//                 String t = s.substring(i,i+n);
//                 if(!tempMap.containsKey(t)){
//                     break;
//                 }else {
//                 	tempMap.put(t,tempMap.get(t)-1);
//                 	if(tempMap.get(t)==0) tempMap.remove(t);
//                 }
//             }
//             if(tempMap.size()==0){
//             	arr.add(l);
//             }
//             l++;
            
//         }
//         return arr;
//     }
// }
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if (words.length == 0 || s.length() == 0) {
            return ans;
        }

        int wordSize = words[0].length();
        int wordCount = words.length;
        int N = s.length();

        HashMap<String,Integer> originalCount = new HashMap<>();
        for(int i = 0; i<words.length; i++){
            originalCount.put(words[i], originalCount.getOrDefault(words[i],0)+1);
        }

        for(int offset = 0; offset<wordSize; offset++){
            HashMap<String,Integer> currentCount = new HashMap<>();
            int start = offset;
            int count = 0;
            for(int end = offset; end + wordSize <= N; end += wordSize){
                String currWord = s.substring(end, end + wordSize);
                if(originalCount.containsKey(currWord)){
                    currentCount.put(currWord, currentCount.getOrDefault(currWord,0)+1);
                    count++;

                    while(currentCount.get(currWord)>originalCount.get(currWord)){
                        String startWord = s.substring(start,start+wordSize);
                        currentCount.put(startWord, currentCount.get(startWord)-1);
                        start+=wordSize;
                        count--;                        
                    }

                    if(count == wordCount){
                        ans.add(start);
                    }
                    
                }
                else{
                    count = 0;
                    start = end + wordSize;
                    currentCount.clear();
                }
            }

        }
        return ans;
    }
}