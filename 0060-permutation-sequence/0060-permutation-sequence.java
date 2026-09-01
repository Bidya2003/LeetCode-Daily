class Solution {
    int count;
    String ans = "";
    public void colleactAllPermutation(int k, int skip, StringBuilder curr, boolean[] visited, List<String> allPermutation) {
        if(curr.length() == visited.length){
            if(count<k){
                allPermutation.add(curr.toString());
                System.out.println("count " + count);
                count++;
            }

            if(count == k) {
                ans = curr.toString();
            }
            return;
        }
        for(int i=1; i<=visited.length; i++){
            if(count==0 && i<skip && curr.length() == 0)
                continue;
            if(count<k && visited[i-1]==false){
                int num = i;
                visited[i-1] = true;
                curr.append(Integer.toString(num));
                colleactAllPermutation(k,skip,curr,visited,allPermutation);
                visited[i-1] = false;     
                curr.delete(curr.length()-1, curr.length());       
            }
        }       
    }
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        count = 0;

        List<String> allPermutation = new ArrayList<>();
        
        int factorial = 1;
        for(int i=1; i<n; i++){
            factorial = factorial*i;
        }

        int x = 1;
        int skip = 0;
        StringBuilder str = new StringBuilder();
        int minus = n-1;
        if(factorial<k){
            int mul = 0;;
            while(mul<k){
                x++;
                mul = factorial * x;
            }
            k = k - factorial * (x-1);
            colleactAllPermutation(k,x,str,visited,allPermutation);
        }
        else if(factorial>k){
            while(factorial>k){
                factorial = factorial / minus;
                minus--;
                str.append(Integer.toString(x));
                visited[x-1] = true;
                x++;
            }
            colleactAllPermutation(k,x,str,visited,allPermutation);
        }
        else{
            colleactAllPermutation(k,-1,str,visited,allPermutation);
        }

        System.out.println(allPermutation);

        return ans;
    }
}