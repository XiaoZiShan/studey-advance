package advance.QuestionTypes.Linked;

import advance.DataStructure.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 */
public class LinkedListCycleSolutionTest {

        private final LinkedListCycleSolution linkedListCycleSolution = new LinkedListCycleSolution();

        @Test
        void hasCycle_Set(){
            // 基于Set，判断链表中是否有环。

            // 输入：head = [3,2,0,-4], pos = 1
            ListNode listNode = new ListNode(3);
            listNode.next = new ListNode(2);
            listNode.next.next = new ListNode(0);
            listNode.next.next.next = new ListNode(-4);
            listNode.next.next.next.next = listNode.next;
             Assertions.assertEquals(Boolean.TRUE,linkedListCycleSolution.hasCycle_Set(listNode));

            // 输入：head = [1,2], pos = 0
            ListNode listNode1 = new ListNode(1);
            listNode1.next = new ListNode(2);
            listNode1.next.next = listNode1.next;
            Assertions.assertEquals(Boolean.TRUE,linkedListCycleSolution.hasCycle_Set(listNode1));

            // 输入：head = [1], pos = -1
            ListNode listNode2 = new ListNode(1);
            Assertions.assertEquals(Boolean.FALSE,linkedListCycleSolution.hasCycle_Set(listNode2));
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
        Assertions.assertEquals(Boolean.TRUE,linkedListCycleSolution.hasCycle_QuickSlowPointer(listNode));

        // 输入：head = [1,2], pos = 0
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = listNode1.next;
        Assertions.assertEquals(Boolean.TRUE,linkedListCycleSolution.hasCycle_QuickSlowPointer(listNode1));

        // 输入：head = [1], pos = -1
        ListNode listNode2 = new ListNode(1);
        Assertions.assertEquals(Boolean.FALSE,linkedListCycleSolution.hasCycle_QuickSlowPointer(listNode2));
    }
}