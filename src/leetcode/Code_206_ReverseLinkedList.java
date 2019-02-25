package leetcode;

/**
 * 反转链表
 */
public class Code_206_ReverseLinkedList {

    // 执行用时: 0 ms, 在Reverse Linked List的Java提交中击败了100.00% 的用户
    public ListNode reverseList(ListNode head) {
        // 记录断链时候的前后节点
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            // 用next指针保存断链处的下一个节点
            next = head.next;
            // 断链，并将该节点的next指向之前保存的前节点
            head.next = pre;
            // 更新保存的最新的前节点
            pre = head;
            // 断链位置往后移
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
