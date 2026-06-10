class Solution {
    Map<String, Boolean> map = new HashMap<String,Boolean>();
	public boolean wordBreak(String s, List<String> wordDict) {
	    
	    if(s.length() == 0) return true;
	    
	    if(map.containsKey(s) && !map.get(s)) return false;
	    for(String str:wordDict){
	        
	        int len = str.length();
	        
	        if(s.indexOf(str) == 0){
	            
	           if(wordBreak(s.substring(len),wordDict)){
	               return true;
	           }
	        }
	        
	        
	    }
	    map.put(s,false);
	    return false;
	}
}