/*
剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：

输入：head = [1,3,2]
输出：[2,3,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法一：递归，使用list记录下来访问的值，最后再赋给数组
执行用时：2 ms, 在所有 Java 提交中击败了41.60% 的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了25.05% 的用户
*/
class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        fun(head, list);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;    
    }
    public void fun(ListNode head, List<Integer> list) {
        if(head == null)
            return;
        fun(head.next, list);
        list.add(head.val);
    }
}


/*
解法二：遍历链表，得到链表长度，然后从后到前记录链表值即可。也可以遍历的时候就记录下来，然后双指针逆序整数数组；也可以建立栈，然后弹栈的同时进行赋值。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了99.91% 的用户
*/
class Solution {
    public int[] reversePrint(ListNode head) {
        int num = 0;
        ListNode p = head;
        while(p != null) {
            num++;
            p = p.next;
        }
        int[] res = new int[num];
        p = head;
        for(int i = num - 1; i >= 0; i--) {
            res[i] = p.val;
            p = p.next;
        }
        return res;    
    }
}

