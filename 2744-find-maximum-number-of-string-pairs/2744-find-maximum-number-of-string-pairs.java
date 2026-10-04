class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;

        for(int i=0; i<words.length; i++){

            StringBuilder sb = new StringBuilder(words[i]);
            StringBuilder reverse = sb.reverse();

            for(int j=i+1; j<words.length; j++){

                if(reverse.length() != words[j].length())
                    continue;

                int c = 0;

                for(c=0; c<reverse.length(); c++){
                    if(reverse.charAt(c) != words[j].charAt(c))
                        break;
                }

                if(c == reverse.length())
                    count++;
            }
        }

        return count;
    }
}