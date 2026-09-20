class Solution {
    class Pair{
        int range;
        int index;
        Pair(int range, int index){
            this.range = range;
            this.index = index;
        }
    }
    public int maxDigitRange(int[] nums) {
        List<Pair> ranges = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            int n = nums[i];
            int largest = Integer.MIN_VALUE;
            int smallest = Integer.MAX_VALUE;

            while(n>0){
                int rev = n % 10;
                n = n/10;

                largest = Math.max(largest,rev);
                smallest = Math.min(smallest,rev);
            }

            ranges.add(new Pair((largest-smallest),nums[i]));
        }

        Collections.sort(ranges, (a,b)->Integer.compare(b.range,a.range));

        int ans = ranges.get(0).index;
        int check = ranges.get(0).range;;

        for(int i=1; i<ranges.size(); i++){
            if(ranges.get(i).range == check){
                ans += ranges.get(i).index;
            }
            else
                break;
        }

        return ans;
    }
}