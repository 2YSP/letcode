package cn.sp.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Ship
 * @Description: 环形链表检测 https://leetcode-cn.com/problems/linked-list-cycle/
 * @Date: Created in 2021/3/27
 */
public class CycleCheck {

    /**
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 解法一：哈希法，遍历链表并将所有节点放入散列表中，检查是否已经存在，如果已存在则有环
     * <p>
     * 时间复杂度O(n),最坏的情况每个节点都要遍历
     * 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();

        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 解法二： 龟兔赛跑算法
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        // 慢指针，每次移动一个节点
        ListNode slow = head;
        // 快指针，每次移动两个节点
        ListNode fast = head.next;
        // 循环条件是否到了最后一个节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 相遇则存在环
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node1;
        CycleCheck obj = new CycleCheck();
        boolean result = obj.hasCycle2(node1);
        System.out.println(result);
    }
}
