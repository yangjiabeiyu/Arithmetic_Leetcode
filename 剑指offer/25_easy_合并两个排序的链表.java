/*
剑指 Offer 25. 合并两个排序的链表

输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
*/

/*
解法一：迭代，谁小连接谁即可
执行用时：1 ms, 在所有 Java 提交中击败了99.51% 的用户
内存消耗：38.1 MB, 在所有 Java 提交中击败了99.86% 的用户
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        while(true) {
            if(l1 == null || l2 == null) {
                p.next = l1 == null ? l2 : l1;
                break;
            }
            if(l1.val >= l2.val) {
                p.next = l2;
                l2 = l2.next;
            }
            else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        return head.next;
    }
}


/*
解法二：递归
执行用时：1 ms, 在所有 Java 提交中击败了99.51% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了96.67% 的用户
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        if(l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        l1.next = mergeTwoLists(l1.next, l2);
        return l1; 
    }
}


