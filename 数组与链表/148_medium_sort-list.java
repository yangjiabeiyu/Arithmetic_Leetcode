/*
排序链表
https://leetcode-cn.com/problems/sort-list/
题目描述
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
示例
输入: 4->2->1->3    输出: 1->2->3->4
*/

/*
解法：归并排序，先找中点，不断往下分裂。复杂度分析：分成两份，排序复杂度为2*n/2，下面分成4份，排序复杂度为2*2*(n/4)；
一直分成n份，复杂度为n/2*2*1，共迭代logn次，所以整体复杂度为O(nlogn)。但递归算法，空间复杂度并不是常数级空间复杂度
执行用时：3 ms, 在所有 Java 提交中击败了98.97% 的用户
内存消耗：40.6 MB, 在所有 Java 提交中击败了93.08% 的用户
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = findMid(head);  // 找到中点
        ListNode newHead = mid.next;   
        mid.next = null;               // 后面置null
        return merge(sortList(head), sortList(newHead));
    }

    public ListNode findMid(ListNode head) {        // 找中点
        if(head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;     // 其实这和设置一个哑节点是一样的，设置哑节点，slow走一步到head，fast走两步到head的next
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode merge(ListNode head1, ListNode head2) {  // 两链表排序
        ListNode res = new ListNode();
        ListNode head = res;
        while(true) {
            if(head1 == null || head2 == null) {
                res.next = head1 == null ? head2 : head1;
                return head.next;
            }
            else {
                if(head1.val >= head2.val) {
                    res.next = head2;
                    head2 = head2.next;
                }
                else {
                    res.next = head1;
                    head1 = head1.next;
                }
                res = res.next;
            }
        }
    }
}
