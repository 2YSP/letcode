package cn.sp.list;

/**
 * @Author: Ship
 * @Description: 删除链表的倒数第N个节点
 * @Date: Created in 2021/3/23
 */
public class RemoveNthFromEnd {

    /**
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     * 解法一：递归
     * 输入： head = [1,2,3,4,5], n = 2
     * 输出： [1,2,3,5]
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        // 倒数第N个节点即正数第
        remove(pre, n);
        return pre.next;
    }

    private int remove(ListNode node, int n) {
        if (node == null || node.next == null) {
            // 倒数第一个
            return 1;
        }
        int i = remove(node.next, n) + 1;
        // 如果当前节点是倒数第N+1个节点，则开始删除
        if (i == n + 1) {
            // 记住下下个节点
            ListNode listNode = node.next.next;
            // 清空指针
            node.next.next = null;
            node.next = listNode;
        }
        return i;
    }


    /**
     * 解法二： 双指针解法
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;
        // 先移动start n步
        while (n != 0) {
            start = start.next;
            n--;
        }
        // 再同时移动start和end,直至start到尾部
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }

        end.next = end.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = null;
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        RemoveNthFromEnd obj = new RemoveNthFromEnd();
        ListNode result = obj.removeNthFromEnd(node1, 1);
        System.out.println(result);
    }
}
