/*
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);

        int ans = 0;

        int countA = 0; int countB = 0; int countC = 0; int countD = 0;

        for(int a=0; a<nums1.length; a++){
            if(a != 0 && nums1[a] == nums1[a-1]){
                ans += countA;
                continue;               
            }
            countA = 0;

            for(int b=0; b<nums2.length; b++){
                if(b != 0 && nums2[b] == nums2[b-1]){
                    ans += countB;
                    countA += countB;
                    continue;
                }
                countB = 0;

                for(int c=0; c<nums3.length; c++){
                    if(c != 0 && nums3[c] == nums3[c-1]){
                        ans += countC;
                        countA += countC;
                        countB += countC;
                        continue;
                    }
                    countC = 0;

                    for(int d=0; d<nums4.length; d++){
                        if(d != 0 && nums4[d] == nums4[d-1]){
                            ans += countD;
                            countA += countD;
                            countB += countD;
                            countC += countD;
                            continue;
                        }
                        countD = 0;

                        long sum = (long) nums1[a] + nums2[b] + nums3[c] + nums4[d];
                        
                        if(sum == 0){
                            countA++;
                            countB++;
                            countC++;
                            countD++;
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
*/


class Solution {
    public int fourSumCount(int[] nums1, int[] nums2,
                            int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>();

        // Store frequency of every pair sum
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int ans = 0;

        // Find complementary pair sums
        for (int c : nums3) {
            for (int d : nums4) {
                int sum = c + d;

                ans += map.getOrDefault(-sum, 0);
            }
        }

        return ans;
    }
}
