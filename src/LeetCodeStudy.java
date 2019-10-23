import DataStructure.ListNode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by CHENT
 */
public class LeetCodeStudy {
    public static void main(String[] args) {//2147483648
      /*  System.out.println(reverse(-123));
        System.out.println(convertx("LEETCODEISHIRING", 4));
        int[] ss = twoSum(new int[]{3, 2, 5, 4, 1}, 6);*/
        ListNode aseNode = new ListNode(4);
        aseNode.next = new ListNode(5);
        aseNode.next.next = new ListNode(1); // 1->2->4, 1->3->4
        aseNode.next.next.next = new ListNode(9); // 1->2->4, 1->3->4
        deleteNode(aseNode);
        // System.out.println(isValid("[]{}()"));
    }

    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null ) return l2;
        if (l2 == null ) return l1;

        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }


    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        // 快慢指针判断是否有环 快指针 +2 慢指针 +1
        ListNode fast = head, slow = head;
        while (fast.next !=null && fast.next.next != null  ) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(String s) {
        // TODO
        HashMap<Character,Character> param = new HashMap<>();
        param.put(')','(');
        param.put(']','[');
        param.put('}','{');
        LinkedList<Character> linkedList = new LinkedList<>();
        for(Character data:s.toCharArray()){
            if (!param.containsKey(data)){
                linkedList.push(data);
            }else if (linkedList.isEmpty()|| param.get(data) != linkedList.pop()){
                return false;
            }
        }
        return linkedList.isEmpty();
    }

    public static int findLastWordLength(String input) {
        // 最后一个字母的位置 / 定义尾部指针从尾部匹配
        int last = input.length() - 1;

        // 找最后一个字母出现的位置 / 过滤尾部空格
        System.out.println(input.charAt(last));
        while (last >= 0 && input.charAt(last) == ' ') {
            last--;
        }

        // 找最后一个字母之前的第一个空白字符 / 找到最后第二位往前追加校验
        int pos = last - 1;
        while (pos >= 0 && input.charAt(pos) != ' ') {
            pos--;
        }

        return last - pos;
    }

    public static void deleteNode(ListNode node) {// (4->5->1->9)
        // 在没有上级节点下删除一个可删除的节点: 例如删除 节点5
        // 将next.val 赋值给 头节点.val; (5->5->1->9)
        node.val  = node.next.val;
        // 赋值值后将next指针指向next的next指针; (5->1->9)
        node.next = node.next.next;
        System.out.println(node);
    }

    public static int reverse(int x) {
        if (x >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(x));
            Long maxCaseOfOverflow = Long.valueOf(sb.reverse().toString());
            if (maxCaseOfOverflow >= Integer.MAX_VALUE) {
                return 0;
            }
            return maxCaseOfOverflow.intValue();
        } else {
            StringBuilder sb = new StringBuilder();
            BigInteger b = new BigInteger(String.valueOf(x));
            sb.append(b.abs().longValue());
            String ss = sb.reverse().toString();
            Long minCaseOfOverflow = Long.valueOf(ss);
            if (minCaseOfOverflow > Long.valueOf(Integer.MAX_VALUE)) {
                return 0;
            }
            return (int) (minCaseOfOverflow - 2 * minCaseOfOverflow);
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     * //Input: 1->2->3->4->5->NULL
     * //Output: 5->4->3->2->1->NULL
     */
    public static ListNode reverseList(ListNode head) {
        // 记录最新节点的链表节点
        ListNode cur = head;
        // 记录反转后的链表
        ListNode prev = null;
        while (cur != null) {
            // 将最新的节点关联指向反转的链表
            ListNode next = cur.next;// 保留下一个结点
            cur.next = prev;         // 指针反转
            prev = cur;              // 前结点后移
            cur = next;              // 前结点后移
        }
        return prev;
    }


    // Z 字形变换

    /**
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 5
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     I
     * E   E S   G
     * E  D  H  N
     * T O   I I
     * C     R
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     */
    public static String convert(String s, int numRows) {
        int numRowsX = numRows - 1;
        if (numRows == 1) {
            return s;
        }
        StringBuilder alexVines = new StringBuilder();
        String[] particle = s.split("/*");
        for (int i = 0; i < particle.length; i++) {
            // 创建临时变量

            if (i % numRowsX == 0) {
                System.out.print(particle[i] + "  ");

            } else {
                int selectNumRows = numRows - 2;
                if (i % selectNumRows == 0) {
                    System.out.println(particle[i]);
                }

                int selectNumRowsx = numRows - 3;
                if (i % selectNumRowsx == 0) {
                    System.out.println(particle[i]);
                }
            }
        }
        return "";
    }

    public static String convertx(String s, int numRows) {
        if (numRows == 1) return s;
        int[] rowIdx = new int[numRows];
        char[] chars = new char[s.length()];
        int n = 0;
        int burketSize = numRows * 2 - 2;
        int burketNum = chars.length / burketSize;
        int rem = chars.length % burketSize;
        for (int i = 1; i < numRows; i++) {
            int flag = i == 1 ? 1 : 2;
            n = flag * burketNum + (rem >= i ? (1 + (burketSize - rem + 1 < i ? 1 : 0)) : 0);
            rowIdx[i] = rowIdx[i - 1] + n;
        }
        int flag = -1;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            chars[rowIdx[curRow]] = c;
            rowIdx[curRow] = rowIdx[curRow] + 1;
            if (curRow == 0 || curRow == numRows - 1) flag = -flag;
            curRow += flag;
        }
        return new String(chars);
    }


    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {
        // 初始化返回值数组
        int[] select = new int[]{-1, -1};
        // 异常边界判断
        if (nums.length < 2 || nums == null) {
            return select;
        }
        // 初始化存查<K,V>容器 (利用 containsKey 进行边存边查)
        HashMap map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 假设 target = 6 ; nums[i] = 2; 那么如果map存储了两个相加为 6 的元素, 即可通过 减 nums[i] 获得匹配;
            if (map.containsKey(target - nums[i])) {
                select[0] = (int) map.get(target - nums[i]);
                select[1] = i;
                break;
            }
            // 滞后避免等值边界异常
            // 输入：
            //  [3,2,4]
            //  6
            //  输出：
            //  [0,0]
            map.put(nums[i], i);
        }
        return select;
    }


    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }

        if (sum == 1) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }

}

