class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(1);

        int idx = 1;
        while(idx<n){
            int size = ans.size();
            for(int i=size-1;i>=0;i--){
                String binary = Integer.toBinaryString(ans.get(i));
                if(i < (size/2)){
                    int temp = idx - binary.length();
                    while(temp>0){
                        binary = '0' + binary;
                        temp--;
                    }
                }
                binary = '1' + binary;
                System.out.println(binary);
                int curr = Integer.parseInt(binary,2);
                ans.add(curr);
            }
            idx++;
        }
        return ans;
    }
}