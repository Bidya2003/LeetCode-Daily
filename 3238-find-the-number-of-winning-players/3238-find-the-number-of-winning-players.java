class Solution { 
    public int winningPlayerCount(int n, int[][] pick) { 
        Map<Integer, Integer> map = new HashMap<>(); 
        Set<Integer> set = new HashSet<>(); 

        for(int i = pick.length - 1; i >= 0; i--) { 

            int key = pick[i][0] * 100 + pick[i][1];

            map.put(key, map.getOrDefault(key, 0) + 1); 

            if(map.get(key) > pick[i][0]) { 
                set.add(pick[i][0]); 
            } 
        } 

        return set.size(); 
    } 
}