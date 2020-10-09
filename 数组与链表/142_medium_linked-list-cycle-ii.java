/*
环形链表II
https://leetcode-cn.com/problems/linked-list-cycle-ii/
题目描述
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
说明：不允许修改给定的链表。
示例
输入：head = [3,2,0,-4], pos = 1    输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
*/

/*
解法一：使用hashset存储各个节点，第一个重复的节点就是开始入环的首节点
执行用时：4 ms, 在所有 Java 提交中击败了24.37% 的用户
内存消耗：40 MB, 在所有 Java 提交中击败了6.85% 的用户
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
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        while(p != null) {
            if(set.contains(p))
                return p;
            set.add(p);
            p = p.next;
        }
        return null;
    }
}


/*
解法二：类比之间找相交链表的
