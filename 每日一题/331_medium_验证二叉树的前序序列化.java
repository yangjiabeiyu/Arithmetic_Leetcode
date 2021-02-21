/*
331. 验证二叉树的前序序列化
https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #

例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。

示例 1:
输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
输出: true
示例 2:
输入: "1,#"
输出: false
*/

/*
解法一：首先，对于二叉树，#是要比数字多一个的；另外前序遍历，从前往后，数字始终是不能比#少的，而且最后一个肯定是#。
所以可以从前往后遍历，设定一个计数器cnt，遇到数字加1，遇到#减1，如果cnt<0就返回false；
遍历到倒数第二个的时候，cnt应该是0，而且最后一个应该是#。
执行用时：6 ms, 在所有 Java 提交中击败了28.47% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了74.13% 的用户
*/
class Solution {
    public boolean isValidSerialization(String preorder) {
        int cnt = 0;
        String[] chs = preorder.split(",");
        for(int i = 0; i < chs.length - 1; i++) {
            if(chs[i].equals("#"))
                cnt--;
            else cnt++;
            if(cnt < 0) return false;
        }
        return cnt == 0 && chs[chs.length - 1].equals("#");
    }
}

/*
解法二：从前往后，遇到#会占据一个槽位，而遇到数字，会占据槽位的同时，新开辟两个槽位，因此可以根据槽位来判断是否有效
执行用时：4 ms, 在所有 Java 提交中击败了81.21% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了45.96% 的用户
*/
class Solution {
    public boolean isValidSerialization(String preorder) {
        int cnt = 1;
        String[] chs = preorder.split(",");
        for(String ch : chs) {
            if(--cnt < 0) return false;
            if(!ch.equals("#")) cnt += 2;
        }
        return cnt == 0;  // 这里不用考虑最后一个是不是#，如果cnt是0，而最后一个不是#，这说明到倒数第二个的时候，cnt=-1，会返回false
    }
}

