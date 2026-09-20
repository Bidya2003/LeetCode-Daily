class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int count = 0;

        for(int i=0; i<events.length; i++){
            if(events[i].equals("W")){
                count++;
                if(count == 10)
                    break;
            }
            else if(events[i].equals("WD") || events[i].equals("NB")){
                score++;
            }
            else{
                score += Integer.parseInt(events[i]);
            }
        }

        System.out.println(count);
        int[] ans = new int[2];
        ans[0] = score;
        ans[1] = count;
        System.out.println(ans[1]);

        return ans;
    }
}