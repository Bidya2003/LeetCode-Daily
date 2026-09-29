class Solution {
    int total = 0;

    public int minimumBoxes(int[] apple, int[] capacity) {
        for(int i : apple){
            total += i;
        }

        Arrays.sort(capacity);

        int sum = 0;
        for(int i=capacity.length-1; i>=0; i--){
            sum += capacity[i];

            if(sum>=total)
                return capacity.length-i;
        }

        return -1;
    }
}