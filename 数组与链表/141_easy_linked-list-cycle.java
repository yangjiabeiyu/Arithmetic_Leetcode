/*
环形链表
https://leetcode-cn.com/problems/linked-list-cycle/
题目描述
给定一个链表，判断链表中是否有环。
示例
输入：head = [3,2,0,-4], pos = 1    输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
*/

/*
解法：双指针，快指针一次两步，慢指针一次一步，每次多走一步，如果最后相同，则说明快指针"超圈"了慢指针，即有环
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.9 MB, 在所有 Java 提交中击败了73.98% 的用户
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode p1 = head, p2 = head;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2)
                return true;
        }
        return false;
    }
}
