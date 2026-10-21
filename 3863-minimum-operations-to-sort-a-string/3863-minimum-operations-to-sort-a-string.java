class Solution {
    String actualStr;
    char[] target;
    int count = Integer.MAX_VALUE;

    public void checkMinSteps(String s, int steps){
        if(actualStr.equals(s)){
            count = Math.min(count,steps);
            return;
        }

        String first = s.substring(0,s.length()-1);
        target = first.toCharArray();
        Arrays.sort(target);
        String sortedStr1 = new String(target);

        if(!first.equals(sortedStr1)){
            checkMinSteps(sortedStr1+s.charAt(s.length()-1), steps+1);
        }

        String last = s.substring(1,s.length());
        target = last.toCharArray();
        Arrays.sort(target);
        String sortedStr2 = new String(target);

        if(!last.equals(sortedStr2)){
            checkMinSteps(s.charAt(0)+sortedStr2, steps+1);
        }
    }
    public int minOperations(String s) {
        char[] actual = s.toCharArray();
        Arrays.sort(actual);
        actualStr = new String(actual);

        checkMinSteps(s,0);

        return (count == Integer.MAX_VALUE) ? -1 : count;
    }
}