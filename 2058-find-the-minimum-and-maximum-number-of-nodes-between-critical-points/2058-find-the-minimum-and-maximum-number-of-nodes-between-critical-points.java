/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> index = new ArrayList<>();

        int[] ans = new int[2];
        Arrays.fill(ans,-1);

        ListNode prev = head;
        ListNode curr = prev.next; int idx = 1;

        if(prev==null || curr==null || curr.next==null)
            return ans;
        
        while(curr.next != null){
            if(curr.val > prev.val && curr.val > curr.next.val){
                index.add(idx);
            }
            if(curr.val < prev.val && curr.val < curr.next.val){
                index.add(idx);
            }
            prev = curr;
            curr = curr.next;
            idx++;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        Collections.sort(index);
        if(index.size()<=1)
            return ans;
        max = index.get(index.size()-1) - index.get(0);

        for(int i=0;i<index.size()-1;i++){
            int diff = Math.abs(index.get(i) - index.get(i+1));
            min = Math.min(min,diff);
        }

        if(max==Integer.MIN_VALUE && min==Integer.MAX_VALUE){
            return ans;
        }

        ans[0] = min;
        ans[1] = max;

        return ans;
    }
}