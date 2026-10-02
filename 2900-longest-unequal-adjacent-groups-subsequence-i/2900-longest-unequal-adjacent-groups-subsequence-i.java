class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        boolean oneLast = false;
        boolean zeroLast = true;

        List<String> ans1 = new ArrayList<>();

        for(int i=0; i<groups.length; i++){
            if(zeroLast == true){
                while(i<groups.length && groups[i] != 1){
                    i++;
                }

                if(i<groups.length)
                    ans1.add(words[i]);
                zeroLast = false;
                oneLast = true;
            }
            else{
                while(i<groups.length && groups[i] != 0){
                    i++;
                }

                if(i<groups.length)
                    ans1.add(words[i]);
                zeroLast = true;
                oneLast = false;
            }
        }

        oneLast = true;
        zeroLast = false;

        List<String> ans2 = new ArrayList<>();

        for(int i=0; i<groups.length; i++){
            if(zeroLast == true){
                while(i<groups.length && groups[i] != 1){
                    i++;
                }

                if(i<groups.length)
                    ans2.add(words[i]);
                zeroLast = false;
                oneLast = true;
            }
            else{
                while(i<groups.length && groups[i] != 0){
                    i++;
                }

                if(i<groups.length)
                    ans2.add(words[i]);
                zeroLast = true;
                oneLast = false;
            }
        }

        return (ans1.size()< ans2.size()) ? ans2 : ans1;
    }
}