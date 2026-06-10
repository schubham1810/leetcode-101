class Solution {
    public boolean isDouble(String str){
        try {
            if(str.contains("Infinity") || str.contains("f") || str.contains("D")) return false;
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isInteger(String str) {
        try {
            if(str.contains("Infinity")) return false;
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean isNumber(String s) {
        List<String> arr = new ArrayList<>();
        if(s.contains("e") || s.contains("E")){
            char[] crr = s.toCharArray();
            boolean e = false;
            StringBuilder sbe = new StringBuilder();
            StringBuilder sae = new StringBuilder();
            for(int i=0;i<crr.length;i++){
                if((crr[i]=='e' || crr[i]=='E') && !e){
                    e = true;
                }else if((crr[i]=='e' || crr[i]=='E') && e){
                    return false;
                }else if(!e){
                    sbe.append(crr[i]);
                }else{
                    sae.append(crr[i]);
                }
            }
            if(sbe.length() == 0 || sae.length() == 0) return false;
            if(sae.toString().contains(".")) return false;
            arr.add(sbe.toString());
            arr.add(sae.toString());
        }else{
            arr.add(s);
        }

        for(int i=0;i<arr.size();i++){
            System.out.println(isDouble(arr.get(i)));
        }

        for(int i=0;i<arr.size();i++){
            if(isDouble(arr.get(i)) || isInteger(arr.get(i))) continue;
            return false;
        }
        return true;
    }
}