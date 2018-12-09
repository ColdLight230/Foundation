package leetcode;

import java.util.Stack;

/**
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * <p>
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 * 示例 1:
 * <p>
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 * 示例 2:
 * <p>
 * 输入: ["5","-2","4","C","D","9","+","+"]
 * 输出: 27
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到-2分。总数是：3。
 * 第3轮：你可以得到4分。总和是：7。
 * 操作1：第3轮的数据无效。总数是：3。
 * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
 * 第5轮：你可以得到9分。总数是：8。
 * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
 * 第7轮：你可以得到9 + 5 = 14分。总数是27。
 * 注意：
 * <p>
 * 输入列表的大小将介于1和1000之间。
 * 列表中的每个整数都将介于-30000和30000之间。
 */
public class Code_682_BaseballGame {
    // 执行用时: 14 ms, 在Baseball Game的Java提交中击败了24.33% 的用户
    public int calPoints(String[] ops) {
        if (ops == null || ops.length < 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int pre = 0;
        int last = 0;
        for (String op : ops) {
            if (op.equals("D")) {
                last = 2 * stack.peek();
                pre = stack.isEmpty() ? 0 : stack.peek();
                stack.push(last);
            } else if (op.equals("+")) {
                stack.push(pre + last);
                pre = last;
                last = stack.isEmpty() ? 0 : stack.peek();
            } else if (op.equals("C")) {
                stack.pop();
                last = pre;
                if (!stack.isEmpty()) {
                    stack.pop();
                    pre = stack.isEmpty() ? 0 : stack.peek();
                    stack.push(last);
                } else {
                    pre = 0;
                }
            } else {
                pre = stack.isEmpty() ? 0 : stack.peek();
                stack.push(Integer.valueOf(op));
                last = Integer.valueOf(op);
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    // 执行用时: 11 ms, 在Baseball Game的Java提交中击败了48.37% 的用户
    public int calPoints1(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("+")) {
                Integer pop = stack.pop();
                int newPush = pop + stack.peek();
                stack.push(pop);
                stack.push(newPush);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Code_682_BaseballGame code = new Code_682_BaseballGame();
        String[] ops = new String[]{"80", "71", "-74", "D", "74", "-61", "96", "+", "C", "70"};
        System.out.println(code.calPoints1(ops));
    }
}
