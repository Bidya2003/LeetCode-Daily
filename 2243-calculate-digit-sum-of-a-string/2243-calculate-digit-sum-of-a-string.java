class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){
            int idx = 0;
            StringBuilder str = new StringBuilder();
            int count = k;
            int sum = 0;
            while(idx < s.length()){
                sum += Integer.parseInt(String.valueOf(s.charAt(idx)));
                count--;

                if(count == 0 || idx == s.length()-1){
                    str.append(sum);
                    count = k;
                    sum = 0;
                }

                idx++;
            }

            s = str.toString();
        }

        return s;
    }
}