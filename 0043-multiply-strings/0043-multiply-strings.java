class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length()==1 && (num1.charAt(0)-'0')==0)
            return Integer.toString(0);
        if(num2.length()==1 && (num2.charAt(0)-'0')==0)
            return Integer.toString(0);

        
        Map<Integer,String> map = new HashMap<>();

        int digit2 = num2.length()-1;
        while(digit2>=0){
            int n = num2.charAt(digit2)-'0';

            if(map.containsKey(n)){
                digit2--;
                continue;
            }

            int digit1 = num1.length()-1;
            int extra = 0;
            StringBuilder ans = new StringBuilder();

            while(digit1>=0){
                int m = num1.charAt(digit1)-'0';
                int mul = m * n + extra;
                extra = mul/10;
                int curr = mul%10;
                ans.insert(0, Integer.toString(curr));
                digit1--;
            }
            if(extra>0){
                ans.insert(0, Integer.toString(extra));
            }

            map.put(n,ans.toString());
            digit2--;
        }

        System.out.println(map);

        digit2 = num2.length()-1;
        String ans = map.get(num2.charAt(digit2)-'0');
        digit2--;
        while(digit2>=0){
            String next = map.get(num2.charAt(digit2)-'0');
            int diff = (num2.length()-1) - digit2;
            StringBuilder sec = new StringBuilder(next);
            while(diff>0){
                sec.append("0");
                diff--;
            }
            next = sec.toString();

            int len1 = ans.length()-1; int len2 = next.length()-1;
            int extra = 0;
            StringBuilder temp = new StringBuilder();
            while(len1>=0 && len2>=0){
                int total = (ans.charAt(len1)-'0') + (next.charAt(len2)-'0') + extra;
                extra = total/10;
                int x = total%10;
                temp.insert(0,Integer.toString(x));
                len1--;
                len2--;
            }
            while(len1>=0){
                int total = (ans.charAt(len1)-'0') + extra;
                extra = total/10;
                int x = total%10;
                temp.insert(0,Integer.toString(x));
                len1--;
            }
            while(len2>=0){
                int total = (next.charAt(len2)-'0') + extra;
                extra = total/10;
                int x = total%10;
                temp.insert(0,Integer.toString(x));
                len2--;
            }
            if(extra>0){
                temp.insert(0,Integer.toString(extra));
            }

            ans = temp.toString();
            digit2--;
        }

        return ans;
    }
}