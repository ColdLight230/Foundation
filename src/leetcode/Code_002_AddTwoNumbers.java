package leetcode;

import com.sun.istack.internal.NotNull;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Code_002_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 错误解法
    // [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
    // [5,6,4]
    public static ListNode addTwoNumbers5(ListNode l1, ListNode l2) {
        long res1 = 0;
        long res2 = 0;
        int power1 = 0;
        int power2 = 0;
        while (l1 != null) {
            res1 += l1.val * (Math.pow(10, power1));
            l1 = l1.next;
            power1++;
        }
        while (l2 != null) {
            res2 += l2.val * (Math.pow(10, power2));
            l2 = l2.next;
            power2++;
        }
        long res = res1 + res2;
        if (res / 10 > 0) {
            ListNode listNode = new ListNode((int) (res % 10));
            ListNode other = listNode;
            while (res / 10 > 0) {
                res /= 10;
                ListNode temp = new ListNode((int) (res % 10));
                other.next = temp;
                other = temp;
            }
            return listNode;
        } else {
            return new ListNode((int) res);
        }
    }

    // 暴力破解1
    public static ListNode addTwoNumbers2(@NotNull ListNode l1, @NotNull ListNode l2) {
        int length1 = 0;
        int length2 = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null) {
            length1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            length2++;
            temp2 = temp2.next;
        }
        int temp;
        if (length1 > length2) {
            temp = (l1.val + l2.val) / 10;
            ListNode listNode = new ListNode((l1.val + l2.val) % 10);
            ListNode other = listNode;
            while (l2.next != null) {
                ListNode tempNode;
                tempNode = new ListNode((l1.next.val + l2.next.val + temp) % 10);
                other.next = tempNode;
                other = tempNode;
                temp = (l1.next.val + l2.next.val + temp) / 10;
                l2 = l2.next;
                l1 = l1.next;
            }
            while (l1.next != null) {
                ListNode tempNode;
                tempNode = new ListNode((l1.next.val + temp) % 10);
                other.next = tempNode;
                temp = (l1.next.val + temp) / 10;
                other = tempNode;
                l1 = l1.next;
            }
            if (temp != 0) {
                other.next = new ListNode(temp);
            }
            return listNode;
        } else {
            temp = (l2.val + l1.val) / 10;
            ListNode listNode = new ListNode((l1.val + l2.val) % 10);
            ListNode other = listNode;
            while (l1.next != null) {
                ListNode tempNode;
                tempNode = new ListNode((l1.next.val + l2.next.val + temp) % 10);
                other.next = tempNode;
                other = tempNode;
                temp = (l1.next.val + l2.next.val + temp) / 10;
                l2 = l2.next;
                l1 = l1.next;
            }
            while (l2.next != null) {
                ListNode tempNode;
                tempNode = new ListNode((l2.next.val + temp) % 10);
                temp = (l2.next.val + temp) / 10;
                other.next = tempNode;
                other = tempNode;
                l2 = l2.next;
            }
            if (temp != 0) {
                other.next = new ListNode(temp);
            }
            return listNode;
        }
    }

    // 简化代码
    // Runtime: 28 ms, faster than 70.26% of Java online submissions for Add Two Numbers.
    public static ListNode addTwoNumbers3(@NotNull ListNode l1, @NotNull ListNode l2) {
        int temp = (l1.val + l2.val) / 10;
        ListNode listNode = new ListNode((l1.val + l2.val) % 10);
        ListNode other = listNode;
        while (l2.next != null && l1.next != null) {
            ListNode tempNode;
            tempNode = new ListNode((l1.next.val + l2.next.val + temp) % 10);
            other.next = tempNode;
            other = tempNode;
            temp = (l1.next.val + l2.next.val + temp) / 10;
            l2 = l2.next;
            l1 = l1.next;
        }
        while (l1.next != null) {
            ListNode tempNode;
            tempNode = new ListNode((l1.next.val + temp) % 10);
            other.next = tempNode;
            temp = (l1.next.val + temp) / 10;
            other = tempNode;
            l1 = l1.next;
        }
        while (l2.next != null) {
            ListNode tempNode;
            tempNode = new ListNode((l2.next.val + temp) % 10);
            temp = (l2.next.val + temp) / 10;
            other.next = tempNode;
            other = tempNode;
            l2 = l2.next;
        }
        if (temp != 0) {
            other.next = new ListNode(temp);
        }
        return listNode;
    }

    // 递归版本
    //  Runtime: 49 ms, faster than 14.73% of Java online submissions for Add Two Numbers.
    public ListNode resList = new ListNode(0);
    public ListNode head = resList;
    public int carry = 0;

    public ListNode addTwoNumbers4(@NotNull ListNode l1, @NotNull ListNode l2) {

        int sum = l1.val + l2.val + carry;
        carry = sum / 10;
        resList.next = new ListNode(sum % 10);
        resList = resList.next;

        if (l2.next != null && l1.next != null) {
            addTwoNumbers4(l1.next, l2.next);
        } else if (l1.next != null) {
            addTwoNumbers4(l1.next, new ListNode(0));
        } else if (l2.next != null) {
            addTwoNumbers4(new ListNode(0), l2.next);
        } else if (carry != 0) {
            resList.next = new ListNode(carry);
            resList = resList.next;
        }
        return head.next;
    }


    // 递归版本2
    // Runtime: 20 ms, faster than 99.27% of Java online submissions for Add Two Numbers.
    public ListNode addTwoNumbers(@NotNull ListNode l1, @NotNull ListNode l2) {
        return recursiveVersion(l1, l2, 0);
    }

    public ListNode recursiveVersion(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) return carry == 0 ? null : new ListNode(1);
        int num1 = l1 == null ? 0 : l1.val;
        int num2 = l2 == null ? 0 : l2.val;
        ListNode res = new ListNode((num1 + num2 + carry) % 10);
        carry = (num1 + num2 + carry) / 10;
        res.next = recursiveVersion(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
        return res;
    }


    public static ListNode LinkList(int[] s) {
        ListNode root = new ListNode(s[0]);//生成链表的根节点，并将数组的第一个元素的值赋给链表的根节点
        ListNode other = root;//生成另一个节点，并让other指向root节点，other在此作为一个临时变量，相当于指针
        for (int i = 1; i < s.length; i++) {//由于已给root赋值，所以i从1开始
            ListNode temp = new ListNode(s[i]);//每循环一次生成一个新的节点,并给当前节点赋值
            other.next = temp;//将other的下一个节点指向生成的新的节点
            other = temp;//将other指向最后一个节点(other的下一个节点)	other=other.getNext();

        }
        return root;
    }

    public static void main(String[] args) {
        ListNode listNode1 = LinkList(new int[]{5});
        ListNode listNode2 = LinkList(new int[]{5});
        // 期望  [0,1]

//        ListNode listNode1 = LinkList(new int[]{5, 6, 4});
//        ListNode listNode2 = LinkList(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
        // 期望  [6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]

//        ListNode listNode1 = LinkList(new int[]{9,8});
//        ListNode listNode2 = LinkList(new int[]{1});
        // 期望  [0,9]

//        ListNode listNode1 = LinkList(new int[]{1});
//        ListNode listNode2 = LinkList(new int[]{9, 9});
        // 期望  [0,0,1]

//        ListNode listNode1 = LinkList(new int[]{3, 7});
//        ListNode listNode2 = LinkList(new int[]{9, 2});
        // 期望  [2,0,1]

        ListNode listNode = new Code_002_AddTwoNumbers().addTwoNumbers(listNode1, listNode2);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}
