class Solution {
    class Pair{
        int num;
        int occurrences;
        Pair(int num, int occurrences){
            this.num = num;
            this.occurrences = occurrences;
        }
    }
    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums.length-k+1];
        int idxAns = 0;

        for(int i=0; i<k; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int left = 0;
        int right = k;

        while(right<=nums.length){

            List<Pair> l = new ArrayList<>();
            for(int key : map.keySet()){
                l.add(new Pair(key, map.get(key)));
            }

            Collections.sort(l, (a,b) -> {
                if(a.occurrences != b.occurrences){
                    return Integer.compare(b.occurrences, a.occurrences);
                }
                else{
                    return Integer.compare(b.num, a.num);
                }
            });

            System.out.println(map);

            int sum = 0;
            for(int i=0;i<x;i++){
                if(i==l.size())
                    break;
                sum += (l.get(i).num * l.get(i).occurrences);
            }

            ans[idxAns] = sum;
            idxAns++;

            if(right == nums.length)
                break;

            map.put(nums[left], map.get(nums[left]) -1);
            left++;
            map.put(nums[right], map.getOrDefault(nums[right], 0) +1);
            right++;
        }

        return ans;
    }
}