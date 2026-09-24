class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        for(int key : map.keySet()){
            int curr = map.get(key);

            if(curr==1)
                continue;
            
            boolean prime = true;
            for(int i=2; i<curr; i++){
                if(curr%i==0){
                    prime = false;
                    break;
                }
            }

            if(prime == true)
                return true;
        }

        return false;
    }
}