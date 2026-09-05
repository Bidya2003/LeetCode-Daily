class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(true){
            int total = 0;
            while(n>0){
                int rem = n%10;
                total = total + (rem*rem);
                n = n/10;
            }
            if(total==1)
                return true;

            if(set.contains(total))
                return false;
            else
                set.add(total);

            n = total;
        }
        
    }
}