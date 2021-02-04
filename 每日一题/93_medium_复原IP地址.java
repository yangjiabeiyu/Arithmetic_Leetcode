/*
93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
https://leetcode-cn.com/problems/restore-ip-addresses/
有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
示例 1：
输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：
输入：s = "0000"
输出：["0.0.0.0"]
*/

/*
解法一：自己写的，比较繁琐，原因在于用了stringbuilder来存储路径，删除的时候很麻烦，也可以使用List存储分隔的字符，然后用String.join()方法
执行用时：2 ms, 在所有 Java 提交中击败了82.15%的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了47.89%的用户
*/
class Solution {
    List<String> res = new ArrayList<>();  // 存放结果
    StringBuilder path = new StringBuilder();   // 存放路径
    public List<String> restoreIpAddresses(String s) {
        dfs(3, 0, s);
        return res;
    }
    public void dfs(int k, int index, String s) {
        if(k == 0 && index < s.length() && index >= s.length() - 3) {  // 如果分隔次数已经用完，并且剩余的长度不大于3
            String sub = s.substring(index, s.length());  // 截取剩余的字符串
            int num = Integer.parseInt(sub);  // 转为数字
            if(num <= 255 && ((num > 0 && s.charAt(index) != '0') || (num == 0 && index == s.length() - 1))) {  // 数字不大于255；大于0且首字符不为0，或者等于0且长度为1
                path.append(sub);  // 加入剩余字符串
                res.add(path.toString());  // 加入结果
                int n = sub.length();  // 回溯，删去添加的内容
                while(n > 0) {
                    path.deleteCharAt(path.length() - 1);
                    n--;
                }
            }
            return;
        }
        if(s.length() - index > (k + 1) * 3) return;  // 如果剩余长度很大，就返回；这里其实也可以再判断一下，如果剩余长度很小，也返回
        if(index == s.length()) return;  // 如果k不为0，而没字符了，也返回，这其实是剩余长度不够的一个特例
        if(s.charAt(index) == '0') {  // 如果当前字符就是0，那就必须截开
            path.append("0.");
            dfs(k - 1, index + 1, s);  // 往下回溯
            path.deleteCharAt(path.length() - 1);  // 删去添加的内容
            path.deleteCharAt(path.length() - 1);
            return;
        }
        for(int i = index; i < s.length() && i < index + 3; i++) {  // 往下不能超过总长度，也不能超过三个
            String sub = s.substring(index, i + 1);
            int cur = Integer.parseInt(sub);
            if(cur > 0 && cur <= 255) {
                path.append(sub + ".");
                dfs(k - 1, i + 1, s);
                int n = sub.length();
                while(n >= 0) {
                    path.deleteCharAt(path.length() - 1);
                    n--;
                }
            }
            else break;
        }
    }
}

/*
解法二：使用linkedlist存储路径
执行用时：3 ms, 在所有 Java 提交中击败了62.51%的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了66.79%的用户
*/
class Solution {
    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if(len < 4 || len > 12) return res;
        dfs(3, 0, s);
        return res;
    }
    public void dfs(int k, int index, String s) {
        int width = s.length() - index;
        if(width > 3 * (k + 1) || width < k + 1) return;
        if(k == 0) {
            String sub = s.substring(index, s.length());
            int num = Integer.parseInt(sub);
            if(num <= 255 && ((num > 0 && s.charAt(index) != '0') || (num == 0 && index == s.length() - 1))) {
                path.add(sub);
                res.add(String.join(".", path));
                path.removeLast();
            }
            return;
        }
        if(s.charAt(index) == '0') {
            path.add("0");
            dfs(k - 1, index + 1, s);
            path.removeLast();
            return;
        }
        for(int i = index; i < s.length() && i < index + 3; i++) {
            String sub = s.substring(index, i + 1);
            int cur = Integer.parseInt(sub);
            if(cur > 0 && cur <= 255) {
                path.add(sub);
                dfs(k - 1, i + 1, s);
                path.removeLast();
            }
        }
    }
}

