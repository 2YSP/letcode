package cn.sp.list;

/**
 * @Author: Ship
 * @Description: 单链表
 * @Date: Created in 2021/3/23
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
