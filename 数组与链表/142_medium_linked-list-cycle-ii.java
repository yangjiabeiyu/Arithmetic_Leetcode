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
解法二：类比之间找相交链表的第一个相交节点，可以将环拆开：slow和fast相遇则说明有环，然后以slow为尾部，fast.next和head找第一个相交节点
执行用时：1 ms, 在所有 Java 提交中击败了38.00% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了70.99% 的用户
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head.next, fast = head.next.next;
        while(slow != fast) {
            if(fast == null || fast.next == null)  // 一旦fast到头，则说明无环
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = fast.next;  //走到这里说明slow和fast相遇，把slow定在原地
        ListNode p = head;
        while(fast != p) {
            fast = fast == slow ? head : fast.next;  // fast继续走，走到slow之后从head走
            p = p == slow ? slow.next : p.next;  // head往前走，走到slow之后从slow.next走，两者相遇的点即是入口节点
        }
        return p;
    }
}


/*
解法三：我们记公共部分长度为a，当slow与fast相遇时，据入口b步，再走c步又会到入口；不妨假设fast已经走了n圈，那么有2*(a+b) = a + n(b+c) + b，即a = (n-1)(b+c) + c
这里慢指针一旦进入环内，必然在第一圈就被追上，原因在于就算快指针在慢指针前面一步，也就是要套一圈，但因为速度是2倍，slow跑不完一圈，fast就能追上。
在快慢指针遇到后，一个指针从fast走，一个从head走，那么第一次遇见的点就是入口节点，即使fast还要绕(n-1)圈。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了86.27% 的用户
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head.next, fast = head.next.next;
        while(slow != fast) {
            if(fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = head;
        while(fast != p) {    // 两个指针向前走即可，一定遇到，且是入口节点
            fast = fast.next;
            p = p.next;
        }
        return p;
    }
}
