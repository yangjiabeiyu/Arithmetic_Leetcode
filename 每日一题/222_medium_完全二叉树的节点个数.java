/*
222. 完全二叉树的节点个数
https://leetcode-cn.com/problems/count-complete-tree-nodes/
给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
若最底层为第 h 层，则该层包含 1~ 2h 个节点。
*/

/*
法一：递归
执行用时：1 ms, 在所有 Java 提交中击败了19.25% 的用户
内存消耗：41 MB, 在所有 Java 提交中击败了39.48% 的用户
*/
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

/*
法二：分成左右两部分，分别获取左右部分的最大深度left和right；
如果两者相等，说明左边已经填满；如果不等，说明左边没有填满，右边填满了，这样就可以直接计算出来填满部分的节点数。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：41.1 MB, 在所有 Java 提交中击败了15.50% 的用户
*/
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = getDepth(root.left), right = getDepth(root.right);
        if(left == right)
            return countNodes(root.right) + (1 << left);
        else
            return countNodes(root.left) + (1 << right);
    }
    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}

/*
法三：在获取最大深度的时候，其实也是要遍历一遍，复杂度也不低；考虑到是完全二叉树，所以只需要一直向左走，看看多少层即可。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：41.1 MB, 在所有 Java 提交中击败了27.06% 的用户
*/
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = getDepth(root.left), right = getDepth(root.right);
        if(left == right)
            return countNodes(root.right) + (1 << left);
        else
            return countNodes(root.left) + (1 << right);
    }
    public int getDepth(TreeNode root) {
        int res = 0;
        while(root != null) {
            res++;
            root = root.left;
        }
        return res;
    }
}

/*
法四：可见题解，用二分；比较有意思的是 利用位运算得到叶子节点的位置；其实位为1，就会表示多于一半，要走到右子节点；否则往左走。
*/

