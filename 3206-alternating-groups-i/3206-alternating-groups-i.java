class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int grps = 0;

        for(int i=0;i<colors.length; i++){
            int first = i;
            int sec = (i+1) % colors.length;
            int third = (i+2) % colors.length;

            if(colors[first] == colors[third] && colors[sec] != colors[first]){
                grps++;
            }
        }

        return grps;
    }
}