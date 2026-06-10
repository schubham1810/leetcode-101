class Solution {
    // private int rubbish(char[] arr, int k){
    //     int l =0;
    //     int count = 0;
    //     Map<Character,Integer> charMap = new HashMap<>();
    //     for(int r=0;r<arr.length;r++){
    //         charMap.put(arr[r],charMap.getOrDefault(arr[r],0)+1);
            
    //         while(charMap.size()>k){
    //             charMap.put(arr[l],charMap.get(arr[l])-1);
    //             if(charMap.get(arr[l])==0){
    //                 charMap.remove(arr[l]);
    //             }
    //             l++;
    //         }
    //         if(charMap.size()<=k){
    //             count+= (r-l+1);
    //         }
    //     }
    //     return count;
    // }
    // public int numberOfSubstrings(String s) {
    //     char[] arr= s.toCharArray();
    //     return rubbish(arr,3)- rubbish(arr,2);
    // }
    public int numberOfSubstrings(String s) {
        char[] arr= s.toCharArray();
        int[] hm = new int[3];
        hm[0]=-1;hm[1]=-1;hm[2]=-1;
        int count =0;
        for(int i=0;i<arr.length;i++){
            hm[arr[i]-'a'] = i;
        
            int min = Math.min(hm[0],Math.min(hm[1],hm[2]));
            count+=(min+1);            
        }
        return count;
    }
}