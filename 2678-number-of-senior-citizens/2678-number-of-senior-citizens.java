class Solution {
    public int countSeniors(String[] details) {
        int count = 0;

        for(int i=0; i<details.length; i++){
            int first = details[i].charAt(11) - '0';
            int sec = details[i].charAt(12) - '0';

            int age = (first * 10) + sec;

            System.out.println(age);

            if(age > 60)
                count++;
        }

        return count;
    }
}