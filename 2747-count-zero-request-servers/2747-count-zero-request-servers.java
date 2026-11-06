/*
//TIME LIMIT EXCEEDED(2125 / 3129 testcases passed)

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int[] ans = new int[queries.length];

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<logs.length; i++){
            list.get(logs[i][0]-1).add(logs[i][1]);
        }

        for(int i=0; i<queries.length; i++){
            int start = queries[i] - x;
            int end = queries[i];

            int count = 0;

            for(List<Integer> l : list){
                boolean present = false;
                for(int num : l){
                    if(num >= start && num <= end){
                        present = true;
                        break;
                    }
                }

                if(present)
                    count++;
            }

            ans[i] = n - count;
        }

        return ans;
    }
}
*/




class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[][] q = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[queries.length];

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0, right = 0;
        int active = 0;

        for (int i = 0; i < q.length; i++) {

            int start = q[i][0] - x;
            int end = q[i][0];

            while (right < logs.length && logs[right][1] <= end) {
                int id = logs[right][0];

                map.put(id, map.getOrDefault(id, 0) + 1);

                if (map.get(id) == 1) {
                    active++;
                }

                right++;
            }

            while (left < right && logs[left][1] < start) {
                int id = logs[left][0];

                map.put(id, map.get(id) - 1);

                if (map.get(id) == 0) {
                    map.remove(id);
                    active--;
                }

                left++;
            }

            ans[q[i][1]] = n - active;
        }

        return ans;
    }
}
