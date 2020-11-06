/*
25. K 个一组翻转链表
https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例：
给你这个链表：1->2->3->4->5
当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5

说明：
    你的算法只能使用常数的额外空间。
    你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
*/

/*
解法一：递归，但不满足常数级空间。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.9 MB, 在所有 Java 提交中击败了65.03% 的用户
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode p = head;
        for(int i = 0; i < k - 1; i++) {
            p = p.next;
            if(p == null) return head;    // 如果不足k个，就直接结束了。
        }
        ListNode temp = reverseKGroup(p.next, k);   // 后续p的next要指向前节点，所以先得到后面的结果。其实后续可以直接把p的next置null，就不用写for循环了，直接while，判断null时终止。
        ListNode cur = head.next, pre = head;   // 翻转
        for(int i = 0; i < k - 1; i++) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        head.next = temp;   // 连接
        return p;  // 返回p
    }
}

/*
解法二：遍历，常数级空间
执行用时：1 ms, 在所有 Java 提交中击败了41.07% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了83.84% 的用户
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;   // 设置哑节点
        ListNode start = dummy, end = dummy;   // 先设置开头和结尾
        while(end.next != null) {   // 后续如果没了就结束
            for(int i = 0; end != null && i < k; i++)   // 找待翻转的尾节点
                end = end.next;
            if(end == null) break;        // 如果尾节点为null，说明不够k个，就break
            ListNode nextStart = start.next;      // 得到下一段翻转组的前start，同时也是当前翻转组的start
            ListNode pNext = end.next;    // 先拿到后续的节点
            end.next = null;      // 断开，后续好翻转
            ListNode cur = nextStart.next, pre = nextStart;  // 翻转
            while(cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            start.next = end;   // end应该接在前start
            nextStart.next = pNext;    // 下一段翻转组的前start后面接上下一段
            start = nextStart;   // 开始下一段的翻转
            end = nextStart;
        }
        return dummy.next;
    }
}

