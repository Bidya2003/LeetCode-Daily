class Solution {
    public int[] decimalRepresentation(int n){
        List<Integer> list = new ArrayList<>();
        int base10 = 1;

        while(n!=0){
            int rev = n%10;
            if(rev!=0){
                list.add(rev*base10);
            }

            n = n/10;
            base10 *= 10;
        }

        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(list.size()-1-i);
        }

        return ans;
    }
}