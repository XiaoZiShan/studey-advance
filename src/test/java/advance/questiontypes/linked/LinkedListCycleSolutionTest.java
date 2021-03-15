package advance.questiontypes.linked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studey.advance.datastructure.ListNode;
import studey.advance.questiontypes.linked.LinkedListCycleSolution;


/**
 * Created by 刷题使我快乐,自律使我自由 !
 *
 *  141. 环形链表
 给定一个链表，判断链表中是否有环。

 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。



 示例 1：

 输入：head = [3,2,0,-4], pos = 1
 输出：true
 解释：链表中有一个环，其尾部连接到第二个节点。


 示例 2：

 输入：head = [1,2], pos = 0
 输出：true
 解释：链表中有一个环，其尾部连接到第一个节点。


 示例 3：

 输入：head = [1], pos = -1
 输出：false
 解释：链表中没有环。




 进阶：

 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 */
 class LinkedListCycleSolutionTest extends LinkedListCycleSolution {

        @Test
        void hasCycle_Set(){
            // 基于Set，判断链表中是否有环。

            // 输入：head = [3,2,0,-4], pos = 1
            ListNode listNode = new ListNode(3);
            listNode.next = new ListNode(2);
            listNode.next.next = new ListNode(0);
            listNode.next.next.next = new ListNode(-4);
            listNode.next.next.next.next = listNode.next;
             Assertions.assertEquals(Boolean.TRUE,hasCycle_Set(listNode));

            // 输入：head = [1,2], pos = 0
            ListNode listNode1 = new ListNode(1);
            listNode1.next = new ListNode(2);
            listNode1.next.next = listNode1.next;
            Assertions.assertEquals(Boolean.TRUE,hasCycle_Set(listNode1));

            // 输入：head = [1], pos = -1
            ListNode listNode2 = new ListNode(1);
            Assertions.assertEquals(Boolean.FALSE,hasCycle_Set(listNode2));
        }

    @Test
    void hasCycle_QuickSlowPointer(){
        // 基于快慢指针，判断链表中是否有环。

        // 输入：head = [3,2,0,-4], pos = 1
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = listNode.next;
        Assertions.assertEquals(Boolean.TRUE,hasCycle_QuickSlowPointer(listNode));

        // 输入：head = [1,2], pos = 0
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = listNode1.next;
        Assertions.assertEquals(Boolean.TRUE,hasCycle_QuickSlowPointer(listNode1));

        // 输入：head = [1], pos = -1
        ListNode listNode2 = new ListNode(1);
        Assertions.assertEquals(Boolean.FALSE,hasCycle_QuickSlowPointer(listNode2));
    }
}