/*
剑指 Offer 52. 两个链表的第一个公共节点

输入两个链表，找出它们的第一个公共节点。
*/

/*
解法：先分别走到尾部，再从另外一个入口进入，则必然会在交点相遇
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：41.2 MB, 在所有 Java 提交中击败了95.68% 的用户
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while(p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}


