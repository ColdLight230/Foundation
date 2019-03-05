package leetcode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * -----------------------------------------------------------------------------
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Code_061_RotateList {

    // 执行用时: 19 ms, 在Rotate List的Java提交中击败了19.43% 的用户
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null) return null;
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        for (int i = 0; i < k % size; i++) {
            head = rotateAStep(head);
        }
        return head;
    }

    private ListNode rotateAStep(ListNode node) {
        if (node == null) return null;
        ListNode tempHead = node;
        ListNode pre = node;
        while (tempHead.next != null) {
            pre = tempHead;
            tempHead = tempHead.next;
        }
        pre.next = null;
        tempHead.next = node;
        return tempHead;
    }

    // 执行用时: 9 ms, 在Rotate List的Java提交中击败了97.64% 的用户
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead, slow = dummyHead;
        int size = 0;
        while (fast.next != null) {
            size++;
            fast = fast.next;
        }
        for (int j = size - k % size; j > 0; j--) {
            slow = slow.next;
        }
        fast.next = dummyHead.next;
        dummyHead.next = slow.next;
        slow.next = null;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode listNode = new Code_061_RotateList().rotateRight(root, 2);
        while (listNode != null) {
            System.out.print("->");
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
