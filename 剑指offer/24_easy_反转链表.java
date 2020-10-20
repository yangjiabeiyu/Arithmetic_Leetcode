/*
剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
*/

/*
解法一：递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了81.63% 的用户
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode q = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return q;
    }
}


/*
解法二：迭代，记录一个pre和cur，记录cur.next后将pre放到cur后，然后更新pre和cur
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.7 MB, 在所有 Java 提交中击败了99.93% 的用户
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head, pre = null;   // 这里需要注意，pre的初值是null
        while(cur != null) {
            ListNode q = cur.next;
            cur.next = pre;
            pre = cur;
            cur = q;
        }
        return pre;
    }
}


