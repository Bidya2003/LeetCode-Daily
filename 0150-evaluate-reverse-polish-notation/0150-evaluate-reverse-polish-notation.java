class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(Integer.parseInt(tokens[0]));
        int idx = 1;

        while(idx < tokens.length){
            if(tokens[idx].equals("+") || tokens[idx].equals("-") || tokens[idx].equals("*") || tokens[idx].equals("/")){
                int num2 = dq.removeFirst();
                int num1 = dq.removeFirst();

                int ope = 0;

                if(tokens[idx].equals("+")){
                    ope = num1 + num2;
                }
                else if(tokens[idx].equals("-")){
                    ope = num1 - num2;
                }
                else if(tokens[idx].equals("*")){
                    ope = num1 * num2;
                }
                else if(tokens[idx].equals("/")){
                    if(num1==0 || num2==0){
                        ope = 0;
                    }
                    else{
                        ope = ope = num1 / num2;
                    }
                }
                dq.addFirst(ope);

                idx++;
                continue;
            }
            dq.addFirst(Integer.parseInt(tokens[idx]));
            idx++;
        }

        int ans = dq.removeFirst();
        return ans;
    }
}