/*
257. 二叉树的所有路径
https://leetcode-cn.com/problems/binary-tree-paths/
给定一个二叉树，返回所有从根节点到叶子节点的路径。
说明: 叶子节点是指没有子节点的节点。

示例:
输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]
解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
*/

/*
解法一：回溯
执行用时：3 ms, 在所有 Java 提交中击败了57.48% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了97.57% 的用户
*/
class Solution {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        treePaths(root);
        return res;
    }
    public void treePaths(TreeNode root) {
        if(root == null) {
            res.add(String.join("->", path));
            return;
        }
        if(root.left != null) {
            path.add(Integer.toString(root.val));
            treePaths(root.left);
            path.remove(path.size() - 1);
        }
        if(root.right != null) {
            path.add(Integer.toString(root.val));
            treePaths(root.right);
            path.remove(path.size() - 1);
        }
        if(root.left == null && root.right == null) {
            path.add(Integer.toString(root.val));
            res.add(String.join("->", path));
            path.remove(path.size() - 1);
        }
    }
}

/*
解法二：使用string来存储path，这样不用回溯
执行用时：11 ms, 在所有 Java 提交中击败了39.79% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了96.52% 的用户
*/
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        treePaths(root, "");
        return res;
    }
    public void treePaths(TreeNode root, String path) {
        if(root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        if(root.left != null)
            treePaths(root.left, path + root.val + "->");
        if(root.right != null)
            treePaths(root.right, path + root.val + "->");
    }
}


