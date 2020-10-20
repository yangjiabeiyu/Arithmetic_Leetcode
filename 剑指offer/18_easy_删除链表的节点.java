/*
剑指 Offer 18. 删除链表的节点
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。

注意：此题对比原题有改动：
原题给出了头结点和待删除节点的引用，并且要求时间复杂度为O(1)，对于中间的节点，可以将next的值赋到待删除节点，然后把next删掉；对于尾节点，则需要一直迭代。整体复杂度确为O(1)

示例 1:
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法：设置哑节点，然后找到待删除节点
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了95.49% 的用户
*/
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode flag = new ListNode();
        flag.next = head;
        ListNode pre = flag;
        while(pre.next != null) {
            if(pre.next.val == val) {
                pre.next = pre.next.next;
                return flag.next;                 // 找到后要及时return或者break，否则后面的pre=pre.next可能出现空指针异常
            }  
            pre = pre.next;
        }
        return flag.next;
    }
}

