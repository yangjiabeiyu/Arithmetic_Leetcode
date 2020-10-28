/*
61. 旋转链表
https://leetcode-cn.com/problems/rotate-list/
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL

示例 2:
输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
*/

/*
解法：先统计长度，同时记录尾节点；然后得到断点前的节点即可。
执行用时：1 ms, 在所有 Java 提交中击败了86.87% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了92.58% 的用户
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode p = head, q = head;
        int len = 1;
        for(; p.next != null; len++) {     // 统计长度及尾节点
            p = p.next;
        }
        p.next = head;   // 接上头结点
        for(int i = 0; i < len - k % len - 1; i++)   // 找到断点的前继
            q = q.next;
        p = q.next;   // 得到新的头结点
        q.next = null;   // 尾部至null
        return p;  // 这里不需要担心p为null，因为前面p后面已经接上了head，如果k恰好是len的倍数，那么p就是head。
    }
}


