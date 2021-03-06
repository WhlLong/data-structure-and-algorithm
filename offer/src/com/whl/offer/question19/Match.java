package com.whl.offer.question19;

/**
 * 正则表达式匹配
 * 请实现一个函数用来匹配包含'.'和'*'的正则表达式，
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次(含0次)。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 特殊情况:
 * 1. 目标串和模式串都为空，匹配成功
 * 2. 模式串到末尾，目标串没有到末尾，匹配失败
 * 3. 模式串未到末尾，目标串到末尾，情况不一定，因为*前面的字符也可以出现0次。
 * <p>
 * 如果第二个字符不是*:
 * 若目标串和模式串中指定位置的字符一致，则匹配成功，模式串和字符串向后移动一个字符。
 * 若目标串和模式串中指定位置的字符不一致，但是字符串中的字符是'.'，则匹配成功，，模式串和字符串向后移动一个字符
 * <p>
 * 如果第二个字符是*
 * 如果目标串和模式串中指定位置的字符一致，这时有两种情况
 * 1. 模式串向后移动两个字符，目标串向后移动一个字符，视为x*匹配1个字符
 * 2. 目标串向后移动一个字符，注意这里只是目标串，视为x*匹配1个字符，然后继续向下匹配。
 * 3. 模式串向后移动两个字符，注意这里只是模式串，视为x*匹配0个字符。
 * <p>
 * 如果目标串和模式串中指定位置的字符不一致：
 * 1. 模式串后移两位，因为*前面的字符可以出现0次，相当于*和它前面的字符都被忽略了。
 */
public class Match {

    public boolean match(char[] str, char[] pattern) {
        if (str == null && pattern == null) {
            return true;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCode(str, strIndex, pattern, patternIndex);
    }

    private boolean matchCode(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //如果目标串到末尾了，模式串也到末尾了，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }

        //如果目标串没到末尾，模式串到末尾了，匹配失败
        if (strIndex < str.length && patternIndex == pattern.length) {
            return false;
        }

        //如果目标串到末尾，模式串没到末尾，不一定匹配失败
        if (strIndex == str.length && patternIndex < pattern.length) {
            // 如果目标串到末尾，模式串没到末尾，但是模式串下一个字符是'*'，那就还有可能匹配成功
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
                return matchCode(str, strIndex, pattern, patternIndex + 2);
            }
            return false;
        }

        //如果下一个字符串是'*'
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //匹配成功
            if (pattern[patternIndex] == str[strIndex] || (strIndex != str.length && pattern[patternIndex] == '.')) {
                //模式串向后移动两个字符，目标串向后移动一个字符，视为x*匹配1个字符
                return matchCode(str, strIndex + 1, pattern, patternIndex + 2)
                        // 目标串向后移动一个字符，注意这里只是目标串，视为x*匹配1个字符，然后继续向下匹配。
                        || matchCode(str, strIndex + 1, pattern, patternIndex)
                        // 模式串向后移动两个字符，注意这里只是模式串，视为x*匹配0个字符。
                        || matchCode(str, strIndex, pattern, patternIndex + 2);
            } else {
                //没有匹配成功，模式串向后移动两个字符，视为x*匹配0个字符
                return matchCode(str, strIndex, pattern, patternIndex + 2);
            }
        }

        //如果下一个字符不是'*'
        if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.') {
            return matchCode(str, strIndex + 1, pattern, patternIndex + 1);
        }

        return false;
    }


    public static void main(String[] args) {
        char[] str = {'b', 'b', 'b', 'b', 'a'};
        char[] pattern = {'.', '*', 'a', '*', 'a'};
        System.out.println(new Match().match(str, pattern));
    }

}
