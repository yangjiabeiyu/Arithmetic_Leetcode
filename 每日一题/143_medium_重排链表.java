/*
143. 重排链表
https://leetcode-cn.com/problems/reorder-list/
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:
给定链表 1->2->3->4, 重新排列为 1->4->2->3.

示例 2:
给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
*/

/*
解法：后半部分翻转，然后穿插相连
执行用时：2 ms, 在所有 Java 提交中击败了83.66% 的用户
内存消耗：41.9 MB, 在所有 Java 提交中击败了9.81% 的用户
*/
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {      // 找中点
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);  // 后半部分翻转
        slow.next = null;
        slow = head;
        while(fast != null) {      // 穿插相连
            ListNode fastNext = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = fastNext;
        }
    }
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

