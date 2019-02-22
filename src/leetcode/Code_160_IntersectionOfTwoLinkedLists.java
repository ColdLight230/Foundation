package leetcode;

public class Code_160_IntersectionOfTwoLinkedLists {

    // 执行用时: 2 ms, 在Intersection of Two Linked Lists的Java提交中击败了80.42% 的用户
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        // 用于记录两条链表长度差
        int n = 0;

        // 获取两条链表的长度差
        while (curA.next != null) {
            n++;
            curA = curA.next;
        }
        while (curB.next != null) {
            n--;
            curB = curB.next;
        }
        // 遍历完链表，终点不是同一个说明不相交
        if (curA != curB) {
            return null;
        }
        // 这里是长度较长的那条链表
        curA = n > 0 ? headA : headB;
        // 这里是长度较短的那条链表
        curB = curA == headA ? headB : headA;
        n = Math.abs(n);
        while (n != 0) {
            // 长链表先走差值的步数
            n--;
            curA = curA.next;
        }
        while (curA != curB) {
            // 一起走，相遇的时候就是第一个相交节点
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
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
