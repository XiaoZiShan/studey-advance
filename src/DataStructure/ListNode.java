package DataStructure;

/**
 * Created by CHENT 链表类
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        ListNode nowNode = this;
        stringBuffer.append("[");

        for (int i = 0; i < 5; i++) {
            if (nowNode.next != null) {
                stringBuffer.append(nowNode.val+",");
                nowNode = nowNode.next;
            }else {
                stringBuffer.append(nowNode.val);
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
