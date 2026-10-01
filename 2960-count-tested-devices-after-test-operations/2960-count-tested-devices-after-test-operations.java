class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;

        for(int i=0; i<batteryPercentages.length; i++){
            if(batteryPercentages[i] == 0){
                continue;
            }
            else{
                count++;
            }
            for(int j=i+1; j<batteryPercentages.length; j++){
                if(batteryPercentages[j] > 0)
                    batteryPercentages[j]--;
            }
        }

        return count;
    }
}