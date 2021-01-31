/*
117. 填充每个节点的下一个右侧节点指针 II
https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
给定一个二叉树
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。

进阶：
    你只能使用常量级额外空间。
    使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
*/

/*
解法：层序遍历即可
执行用时：2 ms, 在所有 Java 提交中击败了40.17% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了89.98% 的用户
*/
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue  = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            for(int i = queue.size(); i > 0; --i) {
                Node node = queue.poll();
                if(i > 1) node.next = queue.peek();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }
}

