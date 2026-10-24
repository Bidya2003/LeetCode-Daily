class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] cal = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String m = "";
        String d = "";
        
        //Alice Arrive
        int AliceArrive = 0;

        m = Character.toString(arriveAlice.charAt(0)) + Character.toString(arriveAlice.charAt(1));

        for(int i=0; i<Integer.parseInt(m)-1; i++){
            AliceArrive += cal[i];
        }
        d = Character.toString(arriveAlice.charAt(3)) + Character.toString(arriveAlice.charAt(4));

        AliceArrive += Integer.parseInt(d);

        //Alice Leave
        int AliceLeave = 0;

        m = Character.toString(leaveAlice.charAt(0)) + Character.toString(leaveAlice.charAt(1));

        for(int i=0; i<Integer.parseInt(m)-1; i++){
            AliceLeave += cal[i];
        }

        d = Character.toString(leaveAlice.charAt(3)) + Character.toString(leaveAlice.charAt(4));

        AliceLeave += Integer.parseInt(d);

        //Bob Arrive
        int BobArrive = 0;

        m = Character.toString(arriveBob.charAt(0)) + Character.toString(arriveBob.charAt(1));

        for(int i=0; i<Integer.parseInt(m)-1; i++){
            BobArrive += cal[i];
        }

        d = Character.toString(arriveBob.charAt(3)) + Character.toString(arriveBob.charAt(4));

        BobArrive += Integer.parseInt(d);

        //Bob Leave
        int BobLeave = 0;

        m = Character.toString(leaveBob.charAt(0)) + Character.toString(leaveBob.charAt(1));

        for(int i=0; i<Integer.parseInt(m)-1; i++){
            BobLeave += cal[i];
        }

        d = Character.toString(leaveBob.charAt(3)) + Character.toString(leaveBob.charAt(4));

        BobLeave += Integer.parseInt(d);

        if(BobArrive >= AliceArrive && BobArrive <= AliceLeave){
            return Math.min(AliceLeave, BobLeave) - BobArrive + 1;
        }
        else if(AliceArrive >= BobArrive && AliceArrive <= BobLeave){
            return Math.min(AliceLeave, BobLeave) - AliceArrive + 1;
        }

        return 0;

    }
}