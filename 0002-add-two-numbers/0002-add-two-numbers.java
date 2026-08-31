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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0; long num2 = 0;
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        ListNode ans = new ListNode(0);
        ListNode head = ans;

        int extra = 0;

        while(curr1!=null && curr2!=null){
            int total = curr1.val + curr2.val + extra;
            extra = total/10;
            int value = total%10;
            ans.next = new ListNode(value);
            ans = ans.next;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while(curr1!=null){
            int total = curr1.val + extra;
            extra = total/10;
            int value = total%10;
            ans.next = new ListNode(value);
            ans = ans.next;

            curr1 = curr1.next;
        }

        while(curr2!=null){
            int total = curr2.val + extra;
            extra = total/10;
            int value = total%10;
            ans.next = new ListNode(value);
            ans = ans.next;

            curr2 = curr2.next;
        }

        while(extra!=0){
            int value = extra % 10;
            extra = extra/10;
            ans.next = new ListNode(value);
            ans = ans.next;
        }

        return head.next;
    }
}