/*
412. Fizz Buzz

写一个程序，输出从 1 到 n 数字的字符串表示。
1. 如果 n 是3的倍数，输出“Fizz”；
2. 如果 n 是5的倍数，输出“Buzz”；
3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。

示例：
n = 15,

返回:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
*/

/*
解法：可以先设置一个初始字符串，如果能被谁整除，就加上它对应的字符串，对应关系可以存储在hash表中，这样本题就扩展了。
执行用时：1 ms, 在所有 Java 提交中击败了98.27% 的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了93.11% 的用户
*/
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> lists = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0)
                lists.add("FizzBuzz");
            else if(i % 3 == 0)
                lists.add("Fizz");
            else if(i % 5 == 0)
                lists.add("Buzz");
            else
                lists.add(String.valueOf(i));      // 整型变字符串也可以：Integer.toString(i);
        }
        return lists;
    }
}

