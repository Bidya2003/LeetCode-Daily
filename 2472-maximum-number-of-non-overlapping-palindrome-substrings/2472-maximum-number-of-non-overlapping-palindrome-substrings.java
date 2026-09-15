class Solution {
    int[] next;
    int[] dp;

    public int findMaxPalindromes(List<List<Integer>> store, int idx){
        if(idx==store.size()){
            return 0;
        }

        if(dp[idx]!= -1){
            return dp[idx];
        }

        int skip = findMaxPalindromes(store, idx+1);
        int take = 1 + findMaxPalindromes(store, next[idx]);

        return dp[idx] = Math.max(skip,take);
    }
    public int maxPalindromes(String s, int k) {
        
        // List<List<Integer>> store = new ArrayList<>();

        // for(int i=0;i<=s.length()-k;i++){
        //     int left = i;
        //     int right = i+k;

        //     StringBuilder str = new StringBuilder(s.substring(left,right));

        //     while(right<=s.length()){
        //         //System.out.println("str - " + str);

        //         String rev = str.reverse().toString();
        //         //System.out.println("rev - " + rev);

        //         str.reverse();
        //         if(str.toString().equals(rev)){
        //             List<Integer> temp = new ArrayList<>();
        //             temp.add(left);
        //             temp.add(right-1);

        //             store.add(temp);

        //             left = right;
        //             right = left+k;

        //             if(right<s.length()) 
        //                 str = new StringBuilder(s.substring(left,right));
        //             else
        //                 break;
        //         }
        //         else{
        //             if(right<s.length()) 
        //                 str.append(s.charAt(right));
        //             right++;
        //         }
        //     }
        // }


        int n = s.length();

        // -------------------------
        // 1. Precompute palindromes
        // -------------------------

        boolean[][] pal = new boolean[n][n];

        boolean notSame = false;
        if(s.length()==k)
            notSame = true;
            
        char c = s.charAt(0);
        for(int i=0; i<n-k ;i++){
            if(s.charAt(i) != c){
                notSame = true;
                break;
            }
        }

        if(notSame==false){
            return n/k;
        }
        else{
            for(int i = n - 1; i >= 0; i--){

                for(int j = i; j < n; j++){

                    if(s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || pal[i + 1][j - 1])){

                        pal[i][j] = true;
                    }
                }
            }
        }


        // -------------------------
        // 2. Store all valid intervals
        // -------------------------

        List<List<Integer>> store = new ArrayList<>();

        for(int i = 0; i <= n - k; i++){

            for(int j = i + k - 1; j < n; j++){

                if(pal[i][j]){

                    List<Integer> temp = new ArrayList<>();

                    temp.add(i);
                    temp.add(j);

                    store.add(temp);
                }
            }
        }

        Collections.sort(store, (a,b)-> Integer.compare(a.get(0),b.get(0)));

        dp = new int[store.size()];
        Arrays.fill(dp,-1);

        next = new int[store.size()];

        for(int i=0; i<store.size(); i++){
            int left = i;
            int right = store.size()-1;
            int ans = store.size();

            while(left<=right){
                int mid = left + (right - left) / 2;

                if(store.get(i).get(1) < store.get(mid).get(0)){
                    ans = mid;
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            next[i] = ans;
        }

        return findMaxPalindromes(store, 0);
    }
}