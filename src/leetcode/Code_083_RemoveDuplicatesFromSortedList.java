package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * -----------------------------------------------------------------------------
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Code_083_RemoveDuplicatesFromSortedList {

    /**
     * 执行用时 : 11 ms , 在所有 Java 提交中击败了 5.70% 的用户
     * 内存消耗 : 37.7 MB , 在所有 Java 提交中击败了 41.43% 的用户
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        TreeSet<Integer> set = new TreeSet<>();
        while (head != null) {
            set.add(head.val);
            head = head.next;
        }
        Iterator<Integer> iterator = set.iterator();
        head = new ListNode(iterator.next());
        ListNode temp = head;
        while (iterator.hasNext()) {
            head.next = new ListNode(iterator.next());
            head = head.next;
        }
        head = temp;
        return head;
    }

    /**
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 5.70% 的用户
     * 内存消耗 : 37.8 MB , 在所有 Java 提交中击败了 40.85% 的用户
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode root = head;
        HashSet<Integer> set = new HashSet<>();
        set.add(root.val);
        while (head.next != null) {
            if (set.contains(head.next.val)) {
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = null;
            } else {
                set.add(head.next.val);
                head = head.next;
            }
        }
        return root;
    }

    /**
     * 因为是有序链表，只需要判断相邻的节点值是否相同即可
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.88% 的用户
     * 内存消耗 : 38 MB , 在所有 Java 提交中击败了 37.86% 的用户
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode root = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = null;
            } else {
                head = head.next;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(3);

        root = new Code_083_RemoveDuplicatesFromSortedList().deleteDuplicates(root);
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


