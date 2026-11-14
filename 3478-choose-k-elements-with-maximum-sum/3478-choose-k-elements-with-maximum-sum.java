/*
//Time Limit Exceeded (622 / 635 testcases passed)

class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        Map<Integer, List<Integer>> numbers = new HashMap<>();

        for(int n : nums1){
            if(!numbers.containsKey(n))
                numbers.put(n, new ArrayList<>());
        }

        for(int i=0; i<nums1.length; i++){
            for(int n : numbers.keySet()){
                if(n > nums1[i]){
                    numbers.get(n).add(i);
                }
            }
        }

        long[] ans = new long[nums1.length];

        for(int i=0; i<nums1.length; i++){
            long sum = 0;
            List<Integer> val = new ArrayList<>();

            for(int n : numbers.get(nums1[i])){
                val.add(nums2[n]);
            }

            Collections.sort(val);

            for(int j=0;  j<val.size() && j<k; j++){
                sum += (long)val.get(val.size()-j-1);
            }

            ans[i] = sum;
        }

        return ans;
    }
}
*/


class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        Integer[] idx = new Integer[n];

        for(int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> Integer.compare(nums1[a], nums1[b]));

        long[] ans = new long[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;

        int i = 0;

        while(i < n) {
            int j = i;

            // Find elements having equal nums1 value
            while(j < n && nums1[idx[j]] == nums1[idx[i]]) {
                j++;
            }

            // Calculate answer before inserting current group
            for(int p = i; p < j; p++) {
                ans[idx[p]] = sum;
            }

            // Insert current group's nums2 values
            for(int p = i; p < j; p++) {
                int value = nums2[idx[p]];

                pq.offer(value);
                sum += value;

                if(pq.size() > k) {
                    sum -= pq.poll();
                }
            }

            i = j;
        }

        return ans;
    }
}
