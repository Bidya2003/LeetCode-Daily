class Solution {
    public int getLeastFrequentDigit(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        while(n != 0){
            int curr = n%10;
            map.put(curr, map.getOrDefault(curr,0) + 1);
            n = n/10;
        }

        int min = Integer.MAX_VALUE;
        int ans = -1;

        for(int key : map.keySet()){
            if(min>map.get(key)){
                ans = key;
                min = map.get(key);
            }
            else if(min == map.get(key)){
                if(ans>key)
                    ans = key;
            }
        }

        return ans;
    }
}