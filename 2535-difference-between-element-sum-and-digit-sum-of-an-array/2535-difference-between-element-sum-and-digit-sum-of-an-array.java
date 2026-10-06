class Solution {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;

        for(int i : nums){
            elementSum += i;

            while(i > 0){
                digitSum += i % 10;
                i = i / 10;
            }
        }

        return Math.abs(elementSum - digitSum);
    }
}