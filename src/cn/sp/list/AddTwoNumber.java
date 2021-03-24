package cn.sp.list;

/**
 * @Author: Ship
 * @Description: 两数相加https://leetcode-cn.com/problems/add-two-numbers/
 * @Date: Created in 2021/3/20
 */
public class AddTwoNumber {

    /**
     * 输入：l1 = [2,4,3] l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 564 = 807
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumber(ListNode l1,ListNode l2){
        // pre指向头节点
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        // 进位
        int carry = 0;
        while (l1 != null && l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            // ?
            cur = cur.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }

        }

        if (carry == 1){
            cur.next =  new ListNode(carry);
        }

        return pre.next;
    }


}
