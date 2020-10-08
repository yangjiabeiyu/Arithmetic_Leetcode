/*
反转链表
https://leetcode-cn.com/problems/reverse-linked-list/
题目描述
反转一个单链表。
示例
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
*/

/*
递归
执行用时：22 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了5.12% 的用户
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        while(temp.next.next != null)
            temp = temp.next;
        ListNode node = temp.next;
        temp.next = null;
        node.next = reverseList(head);
        return node;
    }
}
