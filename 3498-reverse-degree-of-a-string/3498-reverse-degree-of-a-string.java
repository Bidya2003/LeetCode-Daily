class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for(int i=0; i<s.length(); i++){
            int n = (123-s.charAt(i));
            
            sum += (n*(i+1));
        }
        //System.out.println(123-'a');
        return sum;
    }
}