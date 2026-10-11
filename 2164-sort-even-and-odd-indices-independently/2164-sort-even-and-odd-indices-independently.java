class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(i % 2 == 0){
                even.add(nums[i]);
            }
            else{
                odd.add(nums[i]);
            }
        }

        Collections.sort(even);
        Collections.sort(odd, (a,b) -> Integer.compare(b,a));

        int evenIdx = 0;
        int oddIdx = 0;

        for(int i=0; i<nums.length; i++){
            if(i % 2 == 0){
                nums[i] = even.get(evenIdx);
                evenIdx++;
            }
            else{
                nums[i] = odd.get(oddIdx);
                oddIdx++;
            }
        }

        return nums;
    }
}