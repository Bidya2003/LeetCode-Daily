class Solution {
    public String addBinary(String a, String b) {
        int first = a.length()-1;
        int sec = b.length()-1;

        int extra = 0;

        StringBuilder ans = new StringBuilder();

        while(first>=0 && sec>=0){
            int total = (a.charAt(first)-'0') + (b.charAt(sec)-'0') + extra;
            String totalBinary = Integer.toBinaryString(total);
            if(totalBinary.length() > 1){
                extra = totalBinary.charAt(0) - '0';
                ans.insert(0,totalBinary.charAt(1));
            }
            else{
                ans.insert(0,totalBinary.charAt(0));
                extra = 0;
            }

            first--;
            sec--;
        }

        while(first>=0){
            int total = (a.charAt(first)-'0') + extra;
            String totalBinary = Integer.toBinaryString(total);
            if(totalBinary.length() > 1){
                extra = totalBinary.charAt(0) - '0';
                ans.insert(0,totalBinary.charAt(1));
            }
            else{
                ans.insert(0,totalBinary.charAt(0));
                extra = 0;
            }

            first--;
        }

        while(sec>=0){
            int total = (b.charAt(sec)-'0') + extra;
            String totalBinary = Integer.toBinaryString(total);
            if(totalBinary.length() > 1){
                extra = totalBinary.charAt(0) - '0';
                ans.insert(0,totalBinary.charAt(1));
            }
            else{
                ans.insert(0,totalBinary.charAt(0));
                extra = 0;
            }

            sec--;
        }

        if(extra>0){
            ans.insert(0,Integer.toString(extra));
        }

        return ans.toString();
    }
}