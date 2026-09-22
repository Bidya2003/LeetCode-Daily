class Solution {
    class Pair {
        int rev;
        int idx;

        Pair(int rev, int idx) {
            this.rev = rev;
            this.idx = idx;
        }
    }

    public int[] sortByReflection(int[] nums) {
        List<Pair> save = new ArrayList<>();
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {

            int n = nums[i];
            int rev = 0;

            while(n != 0) {
                rev = rev * 2 + (n % 2);
                n = n / 2;
            }

            save.add(new Pair(rev, i));
        }

        Collections.sort(save, (a, b) -> {
            if(a.rev != b.rev) {
                return Integer.compare(a.rev, b.rev);
            }
            else {
                return Integer.compare(nums[a.idx], nums[b.idx]);
            }
        });

        for(int i = 0; i < save.size(); i++) {
            ans[i] = nums[save.get(i).idx];
        }

        return ans;
    }
}