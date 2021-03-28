package cn.sp.list;

/**
 * @Author: Ship
 * @Description: 合并两个有序列表
 * @Date: Created in 2021/3/27
 */
public class MergeTwoLists {

    /**
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 递归实现
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(n+m)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代解法
     * 时间复杂度:O(n+m)
     * 空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 哨兵节点
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }
        // 合并l1 l2后 最多只有一个还未被合并完，直接将链尾指向未合并完成的链表即可
        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        n1.next = n2;
        MergeTwoLists obj = new MergeTwoLists();
        ListNode listNode = obj.mergeTwoLists2(node1, n1);
        System.out.println(listNode);
    }
}
