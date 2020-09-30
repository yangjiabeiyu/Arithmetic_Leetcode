/*
两两交换链表中的节点
https://leetcode-cn.com/problems/swap-nodes-in-pairs/
题目描述
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
示例
给定 1->2->3->4, 你应该返回 2->1->4->3.
*/

/*
解法：使用递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.2 MB, 在所有 Java 提交中击败了94.27% 的用户
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)  //如果后续没有两个节点，则返回头节点即可
            return head;
        ListNode temp = head.next;  //记录next节点
        head.next = swapPairs(temp.next);  // 将当前头结点的next指向next的next
        temp.next = head;  //next节点变为新的头结点
        return temp;
    }
}
