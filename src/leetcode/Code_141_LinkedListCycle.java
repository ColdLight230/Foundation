package leetcode;

public class Code_141_LinkedListCycle {

    // 执行用时: 1 ms, 在Linked List Cycle的Java提交中击败了72.81% 的用户
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode low = head;
        ListNode fast = head;
        while (low != null && fast != null && fast.next !=null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
        root.next.next.next = root;

        System.out.println(new Code_141_LinkedListCycle().hasCycle(root));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
