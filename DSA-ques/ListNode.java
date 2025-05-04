/*Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, 
in the end, should remain as it is.You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        data = data.replaceAll("[\\[\\]]", ""); // Removes '[' and ']'         // Remove brackets if present

        String[] values = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String value : values) {
            current.next = new ListNode(Integer.parseInt(value.trim()));
            current = current.next;
        }
        return dummy.next;
    }
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val).append(",");
            current = current.next;
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        while (true) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = prevGroupEnd;
            for (int i = 0; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }
            if (groupEnd == null) {
                break;
            }
            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null;
            prevGroupEnd.next = reverseList(groupStart);
            groupStart.next = nextGroupStart;
            prevGroupEnd = groupStart;
        }
        return dummy.next;
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
public class try {
    public static void main(String[] args) {
        String input = "[1,2,3,4,5]";
        int k = 2;

        ListNode head = ListNode.deserialize(input);
        Solution solution = new Solution();
        ListNode result = solution.reverseKGroup(head, k);

        System.out.println(result.serialize()); // Output: "2,1,4,3,5"
    }
}
