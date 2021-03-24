package cn.sp.list;

/**
 * @Author: Ship
 * @Description: 206反转单链表 https://leetcode-cn.com/problems/reverse-linked-list/
 * @Date: Created in 2021/3/21
 */
public class ReverseList {

    /**
     * 输入:1->2->3->4->5->NULL
     * 输出:5->4->3->2->1->NULL
     * 解法一：循环
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            // 记住next
            ListNode next = curr.next;
            curr.next = prev;
            // 移动prev指针
            prev = curr;
            // 移动curr
            curr = next;
        }
        return prev;
    }

    /**
     * 解法二： 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // 递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList2(head.next);
        /**
         * 如果链表是 1->2->3->4->5，那么此时的cur就是5
         * 而head就是4，head的下一个是5，下下一个是空
         * 所以head.next.next 就是5 -> 4
         */
        head.next.next = head;
        // 防止链表循环，需要将head.next设置为空
        head.next = null;
        return cur;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ReverseList obj = new ReverseList();
        ListNode listNode = obj.reverseList(node1);
        System.out.println(listNode);

    }
}
