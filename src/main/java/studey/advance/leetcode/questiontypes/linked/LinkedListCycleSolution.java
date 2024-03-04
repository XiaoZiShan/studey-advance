package studey.advance.leetcode.questiontypes.linked;

import studey.advance.leetcode.datastructure.ListNode;

import java.util.HashSet;

;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 */
public class LinkedListCycleSolution {

    public boolean hasCycle_Set(ListNode head) {

        // 如果入参链表过短则不存在环 o(log n)
        if (head == null || head.next == null) {
            return false;
        }

        HashSet<ListNode> set = new HashSet<>();

        // 如果 遍历到最后任然没有发现环则不存在环
        while (head.next != null){

            // 将每一个遍历过的元素存入,之后判重
            if (set.contains(head)){
                return true;
            }

            set.add(head);
            head = head.next;
        }

        return false;
    }

    public boolean hasCycle_QuickSlowPointer (ListNode head) {

        // 如果入参链表过短则不存在环
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        // 如果 快指针遍历到最后仍然没有发现环则不存在环
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // 快指针每轮走两步 慢指针每轮走一步 如果有环快慢指针最终就会相遇
            if (slow == fast){
                return true;
            }
        }

        return false;
    }
}
