/*

class Solution {
    public List<String> braceExpansionII(String expression) {
        List<String> ans = new ArrayList<>();

        int idx = 0;

        List<String> currBrac = new ArrayList<>();
        boolean openBrac = true;

        while(idx < expression.length()){
            if(expression.charAt(idx) == '{'){
                if(currBrac.size()==0){
                    openBrac = true;
                    idx++;
                    continue;
                }
                else{
                    List<String> next = new ArrayList<>();
                    idx++;
                    while(expression.charAt(idx) != '}'){
                        StringBuilder curr = new StringBuilder();
                        while(expression.charAt(idx) != ',' && expression.charAt(idx) != '}'){
                            if(expression.charAt(idx) == '{'){
                                idx++;
                                continue;
                            }
                            curr.append(expression.charAt(idx));
                            idx++;
                        }
                        for(int i=0;i<currBrac.size();i++){
                            String str = currBrac.get(i) + curr.toString();
                            next.add(str);
                        }
                        if(expression.charAt(idx) == '}'){
                            break;
                        }
                        idx++;
                    }
                    currBrac = next;
                    openBrac = false;
                    idx++;
                    continue;
                }
            }

            if(openBrac==true){
                while(expression.charAt(idx) != '}'){
                    StringBuilder curr = new StringBuilder();
                    while(expression.charAt(idx) != ',' && expression.charAt(idx) != '}'){
                        curr.append(expression.charAt(idx));
                        idx++;
                    }
                    // for(int i=0;i<currBrac.size();i++){
                    //     String str = currBrac.get(i) + curr.toString();
                    //     currBrac.add(str);
                    // }
                    currBrac.add(curr.toString());
                    if(expression.charAt(idx) == '}'){
                        break;
                    }
                    idx++;
                }
                openBrac=false;
                idx++;
                continue;
            }

            if(openBrac==false && expression.charAt(idx) != ','){
                for(int i=0;i<currBrac.size();i++){
                    if(!ans.contains(currBrac.get(i))){
                        ans.add(currBrac.get(i));
                    }
                }
            }
            idx++;
        }

        return ans;
    }
}

*/

class Solution {
    int idx = 0;

    public Set<String> representExpansion(String expression) {
        Set<String> res = new HashSet<>();

        Set<String> curr = new HashSet<>();
        curr.add("");

        while(idx < expression.length() && expression.charAt(idx) != '}'){

            if(expression.charAt(idx)==','){
                res.addAll(curr);
                curr = new HashSet();
                curr.add("");
                idx++;
            }
            else if(expression.charAt(idx)=='{'){
                idx++;

                Set<String> next = representExpansion(expression);

                Set<String> temp = new HashSet<>();

                for(String s1 : curr){
                    for(String s2 : next){
                        temp.add(s1 + s2);
                    }
                }

                curr = temp;
                idx++;
            }
            else{
                String ch = String.valueOf(expression.charAt(idx));
                Set<String> temp = new HashSet<>();

                for(String s1 : curr){
                    temp.add(s1+ch);
                }
                curr = temp;
                idx++;
            }
        }

        res.addAll(curr);
        return res;

    }
    public List<String> braceExpansionII(String expression) {
        Set<String> res = representExpansion(expression);

        List<String> ans = new ArrayList<>(res);
        Collections.sort(ans);

        return ans;
    }
}