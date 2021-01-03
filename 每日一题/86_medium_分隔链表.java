/*
86. 分隔链表
https://leetcode-cn.com/problems/partition-list/
给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。

示例：
输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5
*/

/*
解法：先找到待插入点，然后遍历逐个插入即可
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38 MB, 在所有 Java 提交中击败了31.15% 的用户
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1), pre = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while(p.next != null) {
            if(p.next.val >= x) {   // 找到第一个比x大的节点的前继
                pre = p;
                break;
            }
            p = p.next;
        }
        if(pre != p || pre.next == null) return head;  // 如果根本就没有比x大的，或者比x大的是最后一个节点，直接break
        ListNode start = pre.next, cur = pre.next;  // cur是开始找比x小的，start其实就是第一个比x大的节点
        while(cur.next != null) {
            if(cur.next.val < x) {  // 如果比x小，那么需要把该节点移到pre的后面
                ListNode q = cur.next;  // 先记录该节点
                cur.next = q.next;  // cur后接q的next
                q.next = start;  // 该节点后一个应是start
                pre.next = q;  // pre后面接上q
                pre = q;  // 更新pre
            }
            else cur = cur.next;  // 如果不比x小，就直接往下走
        }
        return dummyHead.next;  // 注意这里不要返回head，因为head可能会到链表中间
    }
}

