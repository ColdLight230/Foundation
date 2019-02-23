package leetcode;

/**
 * ��ת����
 */
public class Code_206_ReverseLinkedList {

    // ִ����ʱ: 0 ms, ��Reverse Linked List��Java�ύ�л�����100.00% ���û�
    public ListNode reverseList(ListNode head) {
        // ��¼����ʱ���ǰ��ڵ�
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            // ��nextָ�뱣�����������һ���ڵ�
            next = head.next;
            // �����������ýڵ��nextָ��֮ǰ�����ǰ�ڵ�
            head.next = pre;
            // ���±�������µ�ǰ�ڵ�
            pre = head;
            // ����λ��������
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
