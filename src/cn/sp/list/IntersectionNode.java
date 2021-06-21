package cn.sp.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Ship
 * @Description: 相交链表 https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @Date: Created in 2021/6/17
 */
public class IntersectionNode {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     * 解法一：哈希集合
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(n)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        // 遍历headA并将节点放入集合
        ListNode temp = headA;
        while (temp != null) {
            nodeSet.add(temp);
            temp = temp.next;
        }
        // 遍历headB判断节点是否存在，如果存在则为相交节点
        temp = headB;
        while (temp != null) {
            if (nodeSet.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        // 没有相交，返回null
        return null;
    }


    /**
     * 解法二：双指针（真的妙啊）
     * 空间复杂度：O(m+n)
     * 时间复杂度：O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
