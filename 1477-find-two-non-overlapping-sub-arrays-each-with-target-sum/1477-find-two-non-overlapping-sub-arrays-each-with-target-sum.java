import java.awt.Point;

class Solution {
    int[] next;
    int[][] dp;

    public int calculateMinSumOfLengths(List<Point> subArr, int idx, int k){
        if(k==0){
            return 0;
        }
        if(idx == subArr.size()){
            return Integer.MAX_VALUE;
        }

        if(dp[idx][k] != -1){
            return dp[idx][k];
        }

        int skip = calculateMinSumOfLengths(subArr,idx+1,k);
        int take = calculateMinSumOfLengths(subArr,next[idx],k-1);
        int takeAdd = (1 + subArr.get(idx).y - subArr.get(idx).x);
        if(take == Integer.MAX_VALUE){
            takeAdd = Integer.MAX_VALUE;
        }
        else{
            takeAdd += take;
        }

        int ans = 0;
        if(skip != Integer.MAX_VALUE && takeAdd != Integer.MAX_VALUE)
            ans = Math.min(skip,takeAdd);
        else if(skip == Integer.MAX_VALUE && takeAdd != Integer.MAX_VALUE)
            ans = takeAdd;
        else if(takeAdd == Integer.MAX_VALUE && skip != Integer.MAX_VALUE)
            ans = skip;
        else
            ans = Integer.MAX_VALUE;

        return dp[idx][k] = ans;
    }

    public int minSumOfLengths(int[] arr, int target) {
        List<Point> subArr = new ArrayList<>();

        int left = 0;
        int right = 0;

        int sum = 0;
        while(right <= arr.length && left < arr.length) {
            if(right < arr.length && sum<target){
                sum += arr[right];
                right++;
            }
            else if(sum>target){
                sum -= arr[left];
                left++;
            }
            else if(sum == target){
                Point A = new Point(left,right-1);
                subArr.add(A);
                sum -= arr[left];
                left++;  
            }
            else if(right == arr.length)
                break;
        } 

        System.out.println(subArr);

        Collections.sort(subArr, (a,b)->{
            if(a.x != b.x){
                return Integer.compare(a.x,b.x);
            }
            else{
                return Integer.compare(a.y,b.y);
            }
        });
        next = new int[subArr.size()];

        //System.out.println(subArr);

        for(int i=0; i<subArr.size(); i++){
            left = i;
            right = subArr.size()-1;
            int ans = subArr.size();

            while(left <= right){
                int mid = left + (right - left) / 2;
                if(subArr.get(mid).x > subArr.get(i).y){
                    ans = mid;
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            next[i] = ans;
        }

        dp = new int[subArr.size()][3];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }

        int ans = calculateMinSumOfLengths(subArr,0,2);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}