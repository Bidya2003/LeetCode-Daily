class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        while(num>0){
            if(num>=1000){
                ans.append('M');
                num = num-1000;
            }
            else if(num>=900 && num<1000){
                ans.append('C');
                ans.append('M');
                num = num-900;
            }
            else if(num>=500 && num<900){
                ans.append('D');
                num = num-500;
            }
            else if(num>=400 && num<500){
                ans.append('C');
                ans.append('D');
                num = num-400;
            }
            else if(num>=100 && num<400){
                ans.append('C');
                num = num-100;
            }
            else if(num>=90 && num<100){
                ans.append('X');
                ans.append('C');
                num = num-90;
            }
            else if(num>=50 && num<90){
                ans.append('L');
                num = num-50;
            }
            else if(num>=40 && num<50){
                ans.append('X');
                ans.append('L');
                num = num-40;
            }
            else if(num>=10 && num<40){
                ans.append('X');
                num = num-10;
            }
            else if(num==9){
                ans.append('I');
                ans.append('X');
                num = num-9;
            }
            else if(num>=5 && num<9){
                ans.append('V');
                num = num-5;
            }
            else if(num==4){
                ans.append('I');
                ans.append('V');
                num = num-4;
            }
            else if(num>=1 && num<4){
                ans.append('I');
                num = num-1;
            }
        }
        return ans.toString();
    }
}