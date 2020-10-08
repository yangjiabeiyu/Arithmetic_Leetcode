/*
回文链表
https://leetcode-cn.com/problems/palindrome-linked-list/
题目描述
请判断一个链表是否为回文链表。
示例
输入: 1->2    输出: false
*/

/*
解法：较为直观的方法是遍历链表存储到数组中，双指针判断回文，但空间复杂度为O(n)；
为了达到常数级空间复杂度，可以双指针到达链表中点，将后半部分链表反转，与前半部分作比较。
执行用时：1 ms, 在所有 Java 提交中击败了99.85% 的用户
内存消耗：41.2 MB, 在所有 Java 提交中击败了85.60% 的用户
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode p1 = head, p2 = head;
        while(p2 != null && p2.next != null) {  // 找中点
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode cur = p1, prev = null;
        while(cur != null) {  // 反转后半链表
            ListNode q = cur.next;
            cur.next = prev;
            prev = cur;
            cur = q;
        }
        while(prev != null) {  // 比较前后链表
            if(head.val != prev.val)
                return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}
