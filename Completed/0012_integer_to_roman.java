// class Solution {
//     public String intToRoman(int num) {
//         int[] val={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//         String[] s={"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//         StringBuilder sb=new StringBuilder();
//         for(int i=0;i<val.length;i++){
//             if(num==0){
//                 break;
//             }
//             while(num>=val[i]){
//                 sb.append(s[i]);
//                 num-=val[i];
//             }
//         }
//         return sb.toString();
//     }
// }

class Solution {
    public String intToRoman(int num) {
        String res = "";
        if(num%1000>=0){
            int thousands = num/1000;
            for(int i=0;i<thousands;i++){
                res+= "M";
            }
            num-= (thousands*1000);
        }
        
        if(num%100>=0){
            int hund = num/100;
            num-= (hund*100);
            if(hund==9){
                res+="CM";
            }else if(hund>=5) {
                res+="D";
                hund-=5;
                for(int i=0;i<hund;i++){
                    res+= "C";
                }
            }else if(hund==4){
                res+="CD";
            }else{
                for(int i=0;i<hund;i++){
                    res+= "C";
                }
            }            
        }

        if(num%10>=0){
            int tens = num/10;
            num-= (tens*10);
            if(tens==9){
                res+="XC";
            }else if(tens>=5) {
                res+="L";
                tens-=5;
                for(int i=0;i<tens;i++){
                    res+= "X";
                }
            }else if(tens==4){
                res+="XL";
            }else{
                for(int i=0;i<tens;i++){
                    res+= "X";
                }
            }            
        }

        if(num>0){
            int ones = num;
            num-= ones;
            if(ones==9){
                res+="IX";
            }else if(ones>=5) {
                res+="V";
                ones-=5;
                for(int i=0;i<ones;i++){
                    res+= "I";
                }
            }else if(ones==4){
                res+="IV";
            }else{
                for(int i=0;i<ones;i++){
                    res+= "I";
                }
            }            
        }

        return res;
    }
}