class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int idx = 0;
        while(idx<s.length()){
            if(s.charAt(idx) == 'I'){
                if(idx<s.length()-1 && s.charAt(idx+1)=='V'){
                    ans = ans + 4;
                    idx+=2;
                }
                else if(idx<s.length()-1 && s.charAt(idx+1)=='X'){
                    ans = ans + 9;
                    idx+=2;
                }
                else{
                    ans = ans + 1;
                    idx++;
                }
            }
            else if(s.charAt(idx) == 'V'){
                ans = ans + 5;
                idx++;
            }
            else if(s.charAt(idx) == 'X'){
                if(idx<s.length()-1 && s.charAt(idx+1)=='L'){
                    ans = ans + 40;
                    idx+=2;
                }
                else if(idx<s.length()-1 && s.charAt(idx+1)=='C'){
                    ans = ans + 90;
                    idx+=2;
                }
                else{
                    ans = ans + 10;
                    idx++;
                }
            }
            else if(s.charAt(idx) == 'L'){
                ans = ans + 50;
                idx++;
            }
            else if(s.charAt(idx) == 'C'){
                if(idx<s.length()-1 && s.charAt(idx+1)=='D'){
                    ans = ans + 400;
                    idx+=2;
                }
                else if(idx<s.length()-1 && s.charAt(idx+1)=='M'){
                    ans = ans + 900;
                    idx+=2;
                }
                else{
                    ans = ans + 100;
                    idx++;
                }
            }
            else if(s.charAt(idx) == 'D'){
                ans = ans + 500;
                idx++;
            }
            else if(s.charAt(idx) == 'M'){
                ans = ans + 1000;
                idx++;
            }
        }
        return ans;
    }
}