class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int l=0,r=0,startIndex=-1,count=0,minLen=Integer.MAX_VALUE,endIndex=-1;
        Map<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<m;i++){
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i),0)+1);
        }

        while(r<n){
            if(hm.getOrDefault(s.charAt(r),0)>0){
                count++;
            }
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r),0)-1);

            while(count==m){
                if((r-l+1)<minLen){
                    minLen = (r-l+1);
                    startIndex = l;
                    endIndex = r;
                }
                hm.put(s.charAt(l), hm.getOrDefault(s.charAt(l),0)+1);
                if(hm.getOrDefault(s.charAt(l),0)>0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return startIndex==-1 ? "" : s.substring(startIndex,endIndex+1);
    }
}