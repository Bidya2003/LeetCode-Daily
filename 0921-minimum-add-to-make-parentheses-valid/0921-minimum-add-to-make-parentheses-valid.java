class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.add(i);
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    count++;
                }
            }
        }

        return count + stack.size();
    }
}