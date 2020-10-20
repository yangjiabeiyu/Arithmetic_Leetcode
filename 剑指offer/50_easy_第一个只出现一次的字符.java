/*
剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
示例:
s = "abaccdeff"
返回 "b"

s = "" 
返回 " "

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法一：使用hash表记录每个字符出现次数的情况，只有1次则为true，多于1次则为false。不过在遍历字符串时，可以通过charAt，但效率较低，可以先将字符串转为char数组。
执行用时：46 ms, 在所有 Java 提交中击败了9.23% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了99.65% 的用户
*/
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        for(int i = 0; i < s.length(); i++)
            if(map.get(s.charAt(i)))
                return s.charAt(i);
        return ' ';
    }
}

/*
改进一：不使用charAt来定位字符，将字符串转为char数组。
执行用时：27 ms, 在所有 Java 提交中击败了62.64% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了99.53% 的用户
*/
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for(char ch : chs)
            map.put(ch, !map.containsKey(ch));
        for(char ch : chs)
            if(map.get(ch))
                return ch;
        return ' ';
    }
}


/*
改进二：使用LinkedHashMap可以实现有序的哈希表，由于value为字符，如果都是字母，更是最多只会查找26次。二次查找的复杂度降为O(1)。
执行用时：25 ms, 在所有 Java 提交中击败了68.73% 的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了85.88% 的用户
*/
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] chs = s.toCharArray();
        for(char ch : chs)
            map.put(ch, !map.containsKey(ch));
        for(char ch : map.keySet())
            if(map.get(ch))
                return ch;
        return ' ';
    }
}

