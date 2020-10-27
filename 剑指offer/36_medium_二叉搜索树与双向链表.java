/*
剑指 Offer 36. 二叉搜索树与双向链表
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
*/

/*
解法：中序遍历，设置pre指针
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.4 MB, 在所有 Java 提交中击败了99.09% 的用户
*/
class Solution {
    Node head, pre = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }
    public void dfs(Node root) {
        if(root == null)
            return;
        dfs(root.left);
        if(pre == null)
            head = root;
        else
            pre.right = root;
        root.left = pre;
        pre = root;
        dfs(root.right);
    }
}

