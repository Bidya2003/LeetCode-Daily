/*
//Time Limit Exceeded (959 / 999 testcases passed)

class Solution {
    int minStep;
    Set<List<Integer>> visited;

    public boolean checkSortedOrNot(List<Integer> nums, int[] sortedArr) {
        for(int i= 0; i<nums.size(); i++){
            if(sortedArr[i] != nums.get(i)){
                return false;
            }
        }

        return true;
    }

    public void checkAllOperations(List<Integer> curr, int[] sortedArr, int steps) {
        if(checkSortedOrNot(curr, sortedArr)){
            minStep = Math.min(minStep,steps);
            return;
        }

        if(visited.contains(curr) || steps >= minStep)
            return;

        visited.add(new ArrayList<>(curr));

        // if(steps > minStep)
        //     return;

        List<Integer> reverse = new ArrayList<>(curr);
        Collections.reverse(reverse);
        checkAllOperations(reverse, sortedArr, steps + 1);

        List<Integer> rotate = new ArrayList<>(curr);
        int left = rotate.remove(0);
        rotate.add(left);
        checkAllOperations(rotate, sortedArr, steps + 1);
    }

    public int minOperations(int[] nums) {
        visited = new HashSet<>();

        minStep = Integer.MAX_VALUE;
        List<Integer> curr = new ArrayList<>();
        for (int num : nums) {
            curr.add(num);
        }

        Arrays.sort(nums);

        checkAllOperations(curr, nums, 0);

        return (minStep == Integer.MAX_VALUE) ? -1 : minStep;
    }
}
*/

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Single element already sorted
        if (n == 1) {
            return 0;
        }

        boolean increasing = true;
        boolean decreasing = true;

        int zeroIndex = -1;

        for (int i = 0; i < n; i++) {

            // Find position of 0
            if (nums[i] == 0) {
                zeroIndex = i;
            }

            // Circular next index
            int next = nums[(i + 1) % n];

            // Check whether array is a rotation of:
            // [0, 1, 2, ..., n-1]
            if (next != (nums[i] + 1) % n) {
                increasing = false;
            }

            // Check whether array is a rotation of:
            // [n-1, n-2, ..., 0]
            if (next != (nums[i] - 1 + n) % n) {
                decreasing = false;
            }
        }

        // Case 1:
        // Array is circularly increasing
        //
        // Example: [1,2,3,4,0]
        //
        // Option 1:
        // zeroIndex times left rotate
        //
        // Option 2:
        // reverse -> left rotate -> ... -> reverse
        // This effectively performs right rotations
        if (increasing) {
            int leftRotate = zeroIndex;

            int rightRotate = (n - zeroIndex) + 2;

            return Math.min(leftRotate, rightRotate);
        }

        // Case 2:
        // Array is circularly decreasing
        //
        // We need one reverse operation,
        // but depending on where 0 is,
        // we can reverse before/after rotations.
        if (decreasing) {
            int option1 = zeroIndex + 2;

            int option2 = n - zeroIndex;

            return Math.min(option1, option2);
        }

        // Neither circular increasing nor circular decreasing
        // So sorting is impossible using given operations
        return -1;
    }
}