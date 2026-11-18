
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder ans = new StringBuilder(s);

        Integer[] order = new Integer[indices.length];

        for(int i = 0; i < indices.length; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> Integer.compare(indices[a], indices[b]));

        int poschange = 0;
        int lastEnd = 0;

        for(int i : order) {
            int start = indices[i];
            int end = start + sources[i].length();

            // Check original string boundaries and source
            if(end > s.length() || !s.substring(start, end).equals(sources[i])) {
                continue;
            }

            // Skip overlapping replacements
            if(start < lastEnd) {
                continue;
            }

            int actualStart = start + poschange;
            int actualEnd = actualStart + sources[i].length();

            poschange += targets[i].length() - sources[i].length();

            ans.delete(actualStart, actualEnd);
            ans.insert(actualStart, targets[i]);

            lastEnd = end;
        }

        return ans.toString();
    }
}
