package cn.sp.list;


/**
 * @Author: Ship
 * @Description: 合并K个升序列表
 * @Date: Created in 2021/6/15
 */
public class MergeKLists {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 解法一：顺序合并，依次合并两个链表直到最后一个
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoList(lists[i], ans);
        }
        return ans;
    }


    /**
     * 解法二：分冶合并
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }


    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }


    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode tail = pre;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tail.next = new ListNode(l2.val);

                l2 = l2.next;
            } else {
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return pre.next;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(5);
        a.next = b;
        b.next = c;

        ListNode a2 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        a2.next = b2;
        b2.next = c2;
        ListNode[] lists = {a, a2};
        MergeKLists obj = new MergeKLists();
        ListNode node = obj.mergeKLists2(lists);
        System.out.println(node);

    }
}
